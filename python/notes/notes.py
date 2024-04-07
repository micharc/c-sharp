import json
import codecs
from datetime import datetime
import os.path
import re

'''
1) Multiline records are not supported
2) Records are saved as UTF-16
'''

db_filename = 'notes.json'
data = {}


def list_all_notes():
    if data:
        print('ID, SUBJECT, DATE')
        for id in data:
            print(f"{id}, {data[id]['subject']}, {data[id]['date']}")
        input('Press Enter to continue...')
    else:
        input('List of notes is empty\n'
              'Press Enter to continue...')


def get_current_date():
    return str(datetime.today().strftime('%Y-%m-%d %H:%M:%S'))


def add_new_note():
    subject = str(input('Enter subject: '))
    body = str(input('Enter note body: '))
    data[str(get_new_id())] = {
        'date': get_current_date(),
        'subject': subject,
        'body': body
    }
    write_db()


def print_note(id, press_enter):
    for i in data:
        if i == id:
            record = data[i]
            print(f"\n"
                  f"Note ID = {id}\n"
                  f"Date: {record['date']}\n"
                  f"Subject: {record['subject']}\n\n"
                  f"{record['body']}\n"
                  )
            if press_enter:
                input('Press Enter to continue...')
            return
    input(f'Record with ID={id} was not found\n'
          f'Press Enter to continue...')


def delete_note(id):
    for i in data:
        if i == id:
            data.pop(str(i))
            input(f'Note with ID = {id} was deleted.\n'
                  f'Press Enter to continue...')
            write_db()
            return
    input(f'Record with ID = {id} was not found\n'
          f'Press Enter to continue...')


def check_note_existence(id):
    for i in data:
        if i == id:
            return true
    return false


def edit_note():
    id = input(f'Enter record ID and press Enter: ')
    for i in data:
        if i == id:
            print_note(id, False)
            subject = str(input(f'Enter new subject for ID = {id}: '))
            body = str(input(f'Enter new note body for ID = {id}: '))
            data[str(id)] = {
                'date': get_current_date(),
                'subject': subject,
                'body': body
            }
            write_db()
            return
    input(f'Record with ID = {id} was not found\n'
          f'Press Enter to continue...')


def print_note_by_date():
    date = input('Enter date in format YYYY-MM-DD: ')
    count = 0
    while re.search('^\\d\\d\\d\\d\\-\\d\\d\\-\\d\\d', date) is None:
        print('Incorrect date format\n')
        date = input('Enter date in format YYYY-MM-DD: ')
    for id in data:
        record = data[id]
        if record['date'].__contains__(date):
            print_note(id, False)
            count += 1
    input(f'Found {count} notes with DATE={date}\n'
          f'Press Enter to continue...')


def gui():
    command = 'start'
    while command != 'q':
        print('\nAvailable commands:\n'
              '\tl - List of all notes\n'
              '\ta - Add new note\n'
              '\tp - Print note by ID\n'
              '\td - Delete note by ID\n'
              '\te - Edit note by ID\n'
              '\tr - List of notes by date\n'
              '\tq - Exit\n'
              )
        command = str(input('Enter command and press ENTER: '))
        match command:
            case 'l':
                list_all_notes()
            case 'a':
                add_new_note()
            case 'd':
                id = input(f'Enter record ID and press Enter: ')
                delete_note(id)
            case 'q':
                print('Exiting...')
            case 'p':
                id = input(f'Enter record ID and press Enter: ')
                print_note(id, True)
            case 'e':
                edit_note()
            case 'r':
                print_note_by_date()
            case _:
                print(f'Invalid command was entered - {command}.\n'
                      f'Please reenter command')


def read_db():
    if not os.path.isfile(db_filename):
        return
    db = codecs.open(db_filename, 'r', encoding='utf-8-sig')
    global data
    data = json.load(db)
    db.close()


def write_db():
    db = codecs.open(db_filename, 'w', encoding='utf-8-sig')
    global data
    db.writelines(json.dumps(data, indent=4))
    db.close()


def get_new_id():
    max_id = 0
    for id in data:
        if int(id) > max_id:
            max_id = int(id)
    return str(max_id + 1)


if __name__ == '__main__':
    read_db()
    gui()

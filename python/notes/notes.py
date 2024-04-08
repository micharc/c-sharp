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


def list_all_notes(press_enter):
    if press_enter:
        print('\n===== Listing of all notes =====\n')
    if data:
        print('ID, SUBJECT, DATE')
        for id in data:
            print(f"{id}, {data[id]['subject']}, {data[id]['date']}")
        if press_enter:
            input('\nPress Enter to continue...')
    else:
        input('List of notes is empty\n')
        if press_enter:
            input('Press Enter to continue...')


def get_current_date():
    return str(datetime.today().strftime('%Y-%m-%d %H:%M:%S'))


def add_new_note():
    print('\n===== Adding new note =====\n')
    id = str(get_new_id())
    subject = str(input('Enter subject: '))
    body = str(input('Enter note body: '))
    data[id] = {
        'date': get_current_date(),
        'subject': subject,
        'body': body
    }
    write_db()
    print('\nNew note was added:\n')
    print_note(id, False)


def print_note(id, press_enter):
    if press_enter:
        print('\n ===== Printing note by ID =====\n')
    for i in data:
        if i == id:
            record = data[i]
            print(f"Note ID = {id}\n"
                  f"Date: {record['date']}\n"
                  f"Subject: {record['subject']}\n"
                  f"Body: {record['body']}"
                  )
            if press_enter:
                input('\nPress Enter to continue...')
            return
    input(f'Record with ID={id} was not found\n'
          f'Press Enter to continue...')


def delete_note():
    print()
    list_all_notes(False)
    id = input(f'\nEnter record ID and press Enter: ')
    print('\n===== Deleting note by ID =====\n')
    for i in data:
        if i == id:
            print('Note was deleted:')
            print_note(id, False)
            data.pop(str(i))
            input('\nPress Enter to continue...')
            write_db()
            return
    input(f'Record with ID = {id} was not found\n'
          f'Press Enter to continue...')


def edit_note():
    list_all_notes(False)
    print('\n===== Editing note by ID =====\n')
    id = input(f'Enter record ID and press Enter: ')
    for i in data:
        if i == id:
            print_note(id, False)
            subject = str(input(f'\nEnter new subject for ID = {id}: '))
            body = str(input(f'Enter new note body for ID = {id}: '))
            data[str(id)] = {
                'date': get_current_date(),
                'subject': subject,
                'body': body
            }
            print(f'\nNote ID = {id} was changed:\n')
            print_note(id, False)
            write_db()
            input(f'\nPress Enter to continue...')
            return
    input(f'Record with ID = {id} was not found\n'
          f'Press Enter to continue...')


def print_note_by_date():
    list_all_notes(False)
    print('\n===== Listing note by DATE =====\n')
    date = input('Enter date in format YYYY-MM-DD: ')
    count = 0
    while re.search('^\\d\\d\\d\\d\\-\\d\\d\\-\\d\\d', date) is None:
        print('Incorrect date format\n')
        date = input('Enter date in format YYYY-MM-DD: ')
    print(f'\nFounded notes with DATE = {date}:')
    for id in data:
        record = data[id]
        if record['date'].__contains__(date):
            print()
            print_note(id, False)
            count += 1
    input(f'\nFound {count} notes with DATE = {date}\n'
          f'Press Enter to continue...')


def gui():
    command = 'start'
    while command != 'q':
        print('\nAvailable commands:\n'
              '\ta - Add new note\n'
              '\te - Edit note by ID\n'
              '\td - Delete note by ID\n'
              '\tl - List of all notes\n'
              '\tp - Print note by ID\n'
              '\tr - List of notes by date\n'
              '\tq - Exit\n'
              )
        command = str(input('Enter command and press ENTER: '))
        match command:
            case 'l':
                list_all_notes(True)
            case 'a':
                add_new_note()
            case 'd':
                delete_note()
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

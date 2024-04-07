import json
import codecs
from datetime import datetime
# import sys

db_filename = 'notes.json'
# print('sys.stdout encoding is "' + sys.stdout.encoding + '"')

def list_all_notes():
    print('id, subject')
    for id in data:
        print(f"{id}, {data[id]['subject']}")
    input('Press Enter to continue...')


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
    read_db()


def print_note(id):
    for i in data:
        if (i == id):
            record = data[i]
            print(f"\n"
                  f"Note ID = {id}\n"
                  f"Date: {record['date']}\n"
                  f"Subject: {record['subject']}\n\n"
                  f"{record['body']}\n"
                  )
            input('Press Enter to continue...')
            return
    input(f'Record with ID={id} was not found\nPress Enter to continue...')


def delete_note(id):
    for i in data:
        if (i == id):
            data.pop(str(i))
            input('Note was deleted. Press Enter to continue...')
            return
    input(f'Record with ID={id} was not found\nPress Enter to continue...')
    write_db()

def gui():
    command = 'start'
    while command != 'q':
        print('\nAvailable commands:\n'
              '\tl - List of all notes\n'
              '\ta - Add new note\n'
              '\tp - Print note by ID\n'
              '\td - Delete note by ID\n'
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
                print_note(id)
            case _:
                print(f'Invalid command was entered - {command}.\n'
                      f'Please reenter command')


def read_db():
    db = codecs.open(db_filename, 'r', encoding='utf-8-sig')
    global data
    data = json.load(db)
    db.close()


def write_db():
    db = codecs.open(db_filename, 'w', encoding='utf-8-sig')
    global data
    db.write(json.dumps(data, indent=4))
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

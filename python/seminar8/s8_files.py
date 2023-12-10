import os.path

global db_filename
db_filename = 'p.txt'

def change_file():
    global db_filename
    print(f'Текущий файла справочника: {db_filename}')
    db_filename = input('Введите имя файла справочника (пустая строка = p.txt)\n')
    
    if db_filename == '':
        db_filename = 'p.txt'
    
    if not os.path.exists(db_filename):
        print('Введенный файл не существует!')
        db_filename = 'p.txt'

    print(f'Файл справочника был изменен на {db_filename}, нажмите Enter')
    temp = input()

def copy_record():
    global db_filename
    print(f'Текущий файла справочника: {db_filename}')
    
    destination_db_filename = input('Введите имя файла справочника, в который будет скопирована запись (пустая строка = p2.txt)\n')

    if destination_db_filename == '':
        destination_db_filename = 'p2.txt'

    print(f'Введите номер записи из справочника {db_filename}, которая будет скопирована в справочник {destination_db_filename}: ',end='')
    record_number = int(input())

    with open(db_filename,'r',encoding='utf-8') as file:
        index = 1
        contacts_str = file.read()        
        contacts_list = contacts_str.rstrip().split('\n\n')
        for contact_str in contacts_list:
            if index == record_number:
                record_for_copy = contact_str
            index += 1
    
    with open(destination_db_filename,'a',encoding='utf-8') as file:
        file.write(record_for_copy + '\n\n')
        
    print(f'Запись:\n"{record_for_copy}"\nдобавлена в файл {destination_db_filename}, нажмите Enter\n')
    temp = input()

def add_contact():
    surname = input_surname()
    name = input_name()
    middlename = input_middlename()
    phone = input_phone()
    address = input_address()
    
    return f'{surname} {name} {middlename} {phone}\n{address}\n\n'

def write_contact():
    global db_filename
    record = add_contact()
    with open(db_filename,'a',encoding='utf-8') as file:
        file.write(record)
        print('Запись добавлена, нажмите Enter\n')
        temp = input()
    
def input_surname():
    return input('Введите фамилию: ').title()

def input_name():
    return input('Введите имя: ').title()

def input_middlename():
    return input('Введите отчество: ').title()

def input_phone():
    return input('Введите номер телефона: ')

def input_address():
    return input('Введите город: ').title()

def print_contacts():
    global db_filename
    print(f'Текущий файла справочника: {db_filename}\n')
    with open(db_filename,'r',encoding='utf-8') as file:
        print('============================')
        index = 1
        contacts_str = file.read()        
        contacts_list = contacts_str.rstrip().split('\n\n')
        for contact_str in contacts_list:
            print(f'Номер записи - {index}')
            print(contact_str,'\n')
            index += 1
        print('============================')
        print('Нажмите Enter\n')
        temp = input()        

def search_contacts():
    global db_filename
    print(
        'Варианты поиска:\n'
        '1. По фамилии\n'
        '2. По имени\n'
        '3. По отчеству\n'
        '4. По номеру телефона\n'
        '5. По городу\n'
	)
    
    index_var = int(input('Введите способ поиска: '))-1
    search_str = input('Введите данные для поиска: ').title()
    
    with open(db_filename,'r',encoding='utf-8') as file:
        contacts_str = file.read()
        
    contacts_list = contacts_str.rstrip().split('\n\n')
    
    print()
    print(f'Текущий файл справочника: {db_filename}')
    print('Найденные записи:')
    print('============================')
    found = False
    index = 1
    for contact_str in contacts_list:
        contact_list = contact_str.replace('\n',' ').split(' ')
        if search_str in contact_list[index_var]:
            print(f'Номер записи - {index}')
            print(contact_str,'\n')
            found = True
        index += 1

    if not found:
        print('Не найдено записей по запросу!')
    print('============================')
    print('Нажмите Enter\n')
    temp = input()        

def interface():
    global db_filename
    with open(db_filename,'a'):
        pass

    user_input = 0
    while user_input != '9':
        print(
            '\n'
            f'Текущий файл справочника: {db_filename}\n\n'
            'Выберите команду:\n'
            '1. Добавить контакт\n'
            '2. Вывод всех контактов\n'
            '3. Поиск контактов\n'
            '4. Сменить файл справочника\n'
            '5. Копирование данных в другой справочник\n'
            '9. Выход из программы\n'
        )
        user_input = input('Введите команду: ')
		
        while user_input not in ('1','2','3','4','5','9'):
            print('Некорректная команда! Повторите ввод\n');
            user_input = input('Введите команду: ')
		
        match user_input:
            case '1':
                write_contact()
            case '2':
                print_contacts()
            case '3':
                search_contacts()
            case '4':
                change_file()
            case '5':
                copy_record()
	
if __name__ == '__main__':
    print('\033c', end='') # clear console
    interface()

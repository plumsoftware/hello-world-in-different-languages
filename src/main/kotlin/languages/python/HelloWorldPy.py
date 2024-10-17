import sys
def hello_world_py():
    return "Hello world from Python"

# Преобразуем строку в поток байт
byte_stream = hello_world_py().encode('utf-8')

# Выводим байтовый поток в консоль
sys.stdout.buffer.write(byte_stream)
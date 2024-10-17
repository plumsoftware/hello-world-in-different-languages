#include <iostream>
#include <string>
#include <stdafx.h>

int main() {
  std::string message = "Hello world from C++";
  // Преобразуем строку в поток байт
  const char byteStream = message.c_str();
  // Выводим байтовый поток в консоль
  std::cout.write(byteStream, message.length());
  return 0;
}
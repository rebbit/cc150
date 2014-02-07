// implement a function void reverse(char * str) in c or c++ 
// which reverses a null-terminated string
#include <iostream>

using namespace std;

void reverse(char * str);

int main(int argc, char * argv[]) {
  for (int i = 1; i < argc; i++) {
    reverse(argv[i]);
    cout << argv[i] << endl;
  }
}

void reverse(char * str) {
  char * end = str;
  char tmp;
  if (str) {
    // get the end pos of the string
    while (*end) {
      ++end;
    }
    --end;

    while (str < end) {
      tmp = *str;
      *str++ = *end;
      *end-- = tmp;
    }
  }
}

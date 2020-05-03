#include<stdio.h>

void func(){
    static int x = 0;
    int y = 0;
    printf("x是静态局部变量，在低代码段的《数据区》");
    printf("%d, %p\n",x,&x);
    printf("y是局部变量，在高代码段的《栈》");
    printf("%d, %p\n",y,&y);
    x = x+1;
    y = y+1;
}

int main(){
    func();
    func();
    func();
    return 0;
}
#include <iostream>
#include <Windows.h>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

//获取计算机名称，CPU数量，CPU类型，已用内存百分比，物理内存总数，空闲物理内存
void GetSysInfo()
{
    //1. 定义数据结构存放计算机名称信息
    DWORD MaxComputerlenth = MAX_COMPUTERNAME_LENGTH;
    CHAR ComputerName[MAX_COMPUTERNAME_LENGTH];
    
    // 调用API函数GetComputerName获取计算机名称存放到ComputerName中。
    GetComputerName(ComputerName, &MaxComputerlenth);
    cout << "本台计算机的名称为：" << ComputerName << endl;

    //2. 定义数据结构存放计算机系统信息
    SYSTEM_INFO siSysInfo;
    TCHAR tchBuffer[100];
    // 调用API函数GetSystemInfo获取计算机名称存放到siSysInfo中
    GetSystemInfo(&siSysInfo);
    
    // 输出相关系统信息
    sprintf(tchBuffer,"CPU的数量: %u\tCPU类型: %u", 
        siSysInfo.dwNumberOfProcessors, siSysInfo.dwProcessorType);
    cout << tchBuffer << endl;
    
    //3. 定义数据结构存放内存状态信息
    MEMORYSTATUS stat;
    GlobalMemoryStatus(&stat);
    // 进行输出www.2cto.com
    printf("%d%% 的内存在使用\n", stat.dwMemoryLoad);
    printf("总共有%8ldk的物理内存空间. \n", stat.dwTotalPhys/1024);
    printf("总共有%8ldk空闲的物理内存空间. \n", stat.dwAvailPhys/1024);
}
int main(){
    GetSysInfo();

}

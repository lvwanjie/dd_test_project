#include "com_example_myapplication_jniTest_JniDemo.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_example_myapplication_jniTest_JniDemo_print(JNIEnv *env, jobject thiz){
    printf("invoke get in c++\n)
};

JNIEXPORT jint JNICALL Java_com_example_myapplication_jniTest_JniDemo_getSomething(JNIEnv *env, jobject thiz){

    return 3;
  };
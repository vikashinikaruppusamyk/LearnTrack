# JVM Basics

## JDK, JRE, JVM

**JVM (Java Virtual Machine)** is the engine that actually runs the Java program.
It executes bytecode and includes a class loader, garbage collector, and JIT compiler.

**JRE (Java Runtime Environment)** is what we need to run a Java application.
It includes the JVM plus the standard libraries Java programs depend on.

**JDK (Java Development Kit)** is what we need to build a Java application.
It includes the JRE plus development tools like the compiler (javac).

Think of it this way: JDK ⊃ JRE ⊃ JVM

## What is Bytecode

When we write Java code and compile it, it doesn't become machine code directly.
It becomes bytecode - a middle format stored in '.class' files.
Bytecode is not tied to any specific operating system or hardware.

## Write Once, Run Anywhere

Because Java compiles to bytecode (not machine code), the same .class file can run
on any machine that has a JVM installed - Windows, Mac, or Linux.
The JVM translates bytecode into the machine code that specific OS understands.
This is what makes Java platform independent.
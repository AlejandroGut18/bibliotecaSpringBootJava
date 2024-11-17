package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers;

public interface Mapper<A, B> {
    B mapTo(A a);

    A mapFrom(B b);
}

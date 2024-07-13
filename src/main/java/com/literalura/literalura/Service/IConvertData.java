package com.literalura.literalura.Service;

import com.literalura.literalura.Model.Author;
import com.literalura.literalura.Model.Book;

import java.util.List;

public interface IConvertData {
    <T> T ObtainData(String json, Class<T> classeGenerica);

    <T> List<T> ObtainList(String json, Class<T> classeGenerica);
}

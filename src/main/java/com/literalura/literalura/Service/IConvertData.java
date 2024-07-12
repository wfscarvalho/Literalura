package com.literalura.literalura.Service;

import java.util.List;

public interface IConvertData {
    <T> T ObtainData(String json, Class<T> classy);

    <T> List<T> ObtainList(String json, Class<T> classy);
}

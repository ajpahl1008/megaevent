package com.pahlsoft.megaevent.ui.utility;

public interface PojoFactory<T extends Object> {
    T initNull(T type);

}

package com.bookshop.addons;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by
 *
 * @author ivan
 *         On 6/1/16
 */
public class EditableTableCell {

    //// TODO: 6/1/16 Refactor! Far too many reflection - find out a cleaner way to do it
    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(Class<T> classT) {
        return TextFieldTableCell.forTableColumn(new StringConverter<T>() {
            @Override
            public String toString(T object) {
                return String.valueOf(object);
            }

            @Override
            public T fromString(String string) {
                if (string == null || string.isEmpty())
                    return null;

                try {
                    Method valueOf = classT.getMethod("valueOf", String.class);
                    if (valueOf != null)
                        return (T) valueOf.invoke(null, string);

                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    return null;
                }
                return null;
            }
        });
    }
}

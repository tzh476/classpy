package com.github.zxh.classpy.ibd.datatype;

import com.github.zxh.classpy.common.ParseException;
import com.github.zxh.classpy.ibd.TableSpace;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;

public class PartList extends TableSpacePart {
    private final Class<? extends TableSpacePart> entryClass;
    private final Integer size;

    public PartList(Class<? extends TableSpacePart> entryClass, Integer size) {
        this.entryClass = entryClass;
        this.size = size;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {
        try {
            for (int i = 0; i < size; i++) {
                super.add(readEntry(reader));
            }
        } catch (ReflectiveOperationException e) {
            throw new ParseException(e);
        }
    }

    private TableSpacePart readEntry(TableSpaceReader reader) throws ReflectiveOperationException {
        TableSpacePart c = entryClass.newInstance();
        c.read(reader);
        return c;
    }
}

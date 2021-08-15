package com.github.zxh.classpy.ibd.datatype;

import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.common.ParseException;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;

public class Part extends TableSpacePart {
    private final Class<? extends TableSpacePart> entryClass;

    public Part(Class<? extends TableSpacePart> entryClass) {
        this.entryClass = entryClass;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {
        try {
            readEntry(reader);
        } catch (ReflectiveOperationException e) {
            throw new ParseException(e);
        }
    }

    private void readEntry(TableSpaceReader reader) throws ReflectiveOperationException {
        TableSpacePart cur = entryClass.newInstance();
        cur.read(reader);
        for (FilePart fc : cur.getParts()) {
            this.add((TableSpacePart) fc);
        }
    }
}

package com.github.zxh.classpy.ibd.page.index.record.compact;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.datatype.Bytes;
import com.github.zxh.classpy.ibd.datatype.UInt;

/**
 * Info Flags (4 bits)
 * * Number of Records Owned (4 bits)
 * * Order (13 bits)
 * * Record Type (3 bits)
 * * Next Record Offset (2 byte)
 */
public class UserRecordBody extends TableSpacePart {
    private final UserRecordHeader userRecordHeader;
    private static final Integer RECORD_HEADER_SIZE = 5;

    public UserRecordBody(UserRecordHeader userRecordHeader) {
        this.userRecordHeader = userRecordHeader;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {
        Integer nextOffset = ((UInt) userRecordHeader.getParts().get(2)).getValue();
        Integer curContentSize = nextOffset - RECORD_HEADER_SIZE;
        Bytes bytes = new Bytes(curContentSize);
        add("content", bytes);//为正数才读取，有一个bug，就是最后一条数据会读取失败if(curContentSize > 0){    bytes.read(reader);}
    }
}

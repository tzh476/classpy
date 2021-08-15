package com.github.zxh.classpy.ibd.page;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.pagecontent.FileHeader;
import com.github.zxh.classpy.ibd.page.pagecontent.FileSpaceHeader;
import com.github.zxh.classpy.ibd.page.pagecontent.FileTrailer;
import com.github.zxh.classpy.ibd.page.pagecontent.XdesEntry;

/**
 *    public FileSpaceHeader fileSpaceHeader;
 *     public XdesEntry[] XDESEntrys;
 *     public byte[] empty;
 *    public FileTrailer fileTrailer;
 */
public class FspHdrPage extends TableSpacePart {
    private static final Integer XDES_ENTRY_NUM = 256;
    public static Integer EMPTY_SIZE = 5986;

    {
        part("FileHeader", FileHeader.class);
        part("FileSpaceHeader", FileSpaceHeader.class);
        partList("XDESEntrys", XdesEntry.class, XDES_ENTRY_NUM);
        bytes("empty", EMPTY_SIZE);
        part("FileTrailer", FileTrailer.class);
    }
}

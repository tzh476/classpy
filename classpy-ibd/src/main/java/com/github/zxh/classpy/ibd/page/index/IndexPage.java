package com.github.zxh.classpy.ibd.page.index;

import com.github.zxh.classpy.ibd.page.index.record.compact.UserRecords;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;
import com.github.zxh.classpy.ibd.page.index.record.compact.SysRecord;

/**
 *     public ListNode inodePageList;//存储INODE链表中，当前节点的上一个页和下一个页
 *     public INodeEntry[] iNodeEntries;
 *     public byte[] empty;
 */
public class IndexPage extends TableSpacePart {
    private FileHeader fileHeader;
    public IndexPage(FileHeader fileHeader) {
        this.fileHeader = fileHeader;
    }
    {
        //part("FileHeader", FileHeader.class);
        //FileHeader fileHeader = new FileHeader();
       // add("fileHeader", fileHeader);

        //part("IndexPageHeader", IndexPageHeader.class);
        IndexPageHeader pageHeader = new IndexPageHeader();
        add("IndexPageHeader", pageHeader);

        //part("infimum", SysRecord.class);
        SysRecord infimum = new SysRecord();
        add("infimum", infimum);
        part("supremum", SysRecord.class);
        add("UserRecords", new UserRecords(fileHeader, pageHeader, infimum));
        add("FreeSpace", new FreeSpace(fileHeader, pageHeader));
        add("PageDirectory", new PageDirectory(pageHeader));
        part("FileTrailer", FileTrailer.class);
    }


}

package com.github.zxh.classpy.ibd.page;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.pagecontent.FileHeader;
import com.github.zxh.classpy.ibd.page.pagecontent.FileTrailer;
import com.github.zxh.classpy.ibd.page.pagecontent.INodeEntry;
import com.github.zxh.classpy.ibd.page.pagecontent.IndexPageHeader;

/**
 *     public ListNode inodePageList;//存储INODE链表中，当前节点的上一个页和下一个页
 *     public INodeEntry[] iNodeEntries;
 *     public byte[] empty;
 */
public class IndexPage extends TableSpacePart {


    {
        part("FileHeader", FileHeader.class);
        part("IndexPageHeader", IndexPageHeader.class);
        part("infimum", SysRecord.class);
        part("supremum", SysRecord.class);

        part("FileTrailer", FileTrailer.class);
    }
}

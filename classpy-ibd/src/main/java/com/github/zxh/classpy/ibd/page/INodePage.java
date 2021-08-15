package com.github.zxh.classpy.ibd.page;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.ListNode;
import com.github.zxh.classpy.ibd.page.pagecontent.FileHeader;
import com.github.zxh.classpy.ibd.page.pagecontent.FileTrailer;
import com.github.zxh.classpy.ibd.page.pagecontent.INodeEntry;

/**
 *     public ListNode inodePageList;//存储INODE链表中，当前节点的上一个页和下一个页
 *     public INodeEntry[] iNodeEntries;
 *     public byte[] empty;
 */
public class INodePage extends TableSpacePart {
    public static Integer EMPTY_SIZE = 6;
    public static Integer INODE_ENTRY_SIZE = 85;


    {
        part("FileHeader", FileHeader.class);
        part("inodePageList", ListNode.class);
        partList("iNodeEntries", INodeEntry.class, INODE_ENTRY_SIZE);
        bytes("empty", EMPTY_SIZE);
        part("FileTrailer", FileTrailer.class);
    }
}

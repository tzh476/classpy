package com.github.zxh.classpy.ibd;


import com.github.zxh.classpy.ibd.page.FspHdrPage;
import com.github.zxh.classpy.ibd.page.INodePage;
import com.github.zxh.classpy.ibd.page.IbufBitmapPage;
import com.github.zxh.classpy.ibd.page.IndexPage;

public class TableSpace extends TableSpacePart {

    {
        part("FspHdrPage", FspHdrPage.class);
        part("IbufBitmapPage", IbufBitmapPage.class);
        part("INodePage", INodePage.class);
        part("IndexPage", IndexPage.class);
    }


}

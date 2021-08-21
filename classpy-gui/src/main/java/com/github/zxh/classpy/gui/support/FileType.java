package com.github.zxh.classpy.gui.support;

import com.github.zxh.classpy.bitcoin.BlockParser;
import com.github.zxh.classpy.bitcoin.TxParser;
import com.github.zxh.classpy.classfile.ClassFileParser;
import com.github.zxh.classpy.common.FileParser;
import com.github.zxh.classpy.ibd.SysTableSpaceParser;
import com.github.zxh.classpy.ibd.TableSpaceParser;
import com.github.zxh.classpy.lua.BinaryChunkParser;
import com.github.zxh.classpy.wasm.WasmBinParser;
import javafx.scene.image.Image;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Supported file types.
 */
public enum FileType {

    FOLDER       ("/folder.png",  "Folder",              "/",       null),
    JAVA_JAR     ("/jar.png",     "Java JAR",            "*.jar",   null),
    IBD   ("/ibd16.png",    "IBD",          "*.ibd", new TableSpaceParser()),
    IBDATA   ("/ibd16.png",    "ibdata",          "*.*", new SysTableSpaceParser()),

    JAVA_JMOD    ("/jmod.png",    "Java JMOD",           "*.jmod",  null),
    JAVA_CLASS   ("/java.png",    "Java Class",          "*.class", new ClassFileParser()),
    LUA_BC       ("/lua.png",     "Lua Binary Chunk",    "*.luac",  new BinaryChunkParser()),
    WASM         ("/wasm.png",    "Wasm Binary Code",    "*.wasm",  new WasmBinParser()),
    BITCOIN_BLOCK("/bitcoin.png", "Bitcoin Block",       "?",       new BlockParser()),
    BITCOIN_TX   ("/bitcoin.png", "Bitcoin Transaction", "?",       new TxParser()),
    UNKNOWN      ("/file.png",    "Unknown",             "*.*",     FileParser.NOP),
    ;

    public final Image icon;
    public final ExtensionFilter filter;
    public final FileParser parser;

    FileType(String icon,
             String description,
             String extension,
             FileParser parser) {
        this.icon = ImageHelper.loadImage(icon);
        this.filter = new ExtensionFilter(description, extension);
        this.parser = parser;
    }

    public boolean isZip() {
        return this == JAVA_JAR || this == JAVA_JMOD;
    }

    public boolean isBitcoin() {
        return this == BITCOIN_BLOCK || this == BITCOIN_TX;
    }

    public boolean isIbdOrIbdata() {
        return this == IBD || this == IBDATA;
    }
}

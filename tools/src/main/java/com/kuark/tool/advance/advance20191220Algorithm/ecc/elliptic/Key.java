package com.kuark.tool.advance.advance20191220Algorithm.ecc.elliptic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/** */
public interface Key {
    public Key readKey(InputStream in) throws IOException;
    public void writeKey(OutputStream out) throws IOException;
    public Key getPublic();
    public boolean isPublic();
}

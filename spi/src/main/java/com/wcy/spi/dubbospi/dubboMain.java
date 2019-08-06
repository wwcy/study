package com.wcy.spi.dubbospi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;

/**
 * @auth wcy on 2019/8/5.
 */
public class dubboMain {

    public static void main(String[] args) {
        ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        Protocol p = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("filter");
        System.out.println(p.getDefaultPort());
    }
}

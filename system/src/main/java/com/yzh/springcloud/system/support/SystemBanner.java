package com.yzh.springcloud.system.support;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 说明：系统banner图，启动时展示
 * 生成工具：http://patorjk.com/software/taag
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
public class SystemBanner implements Banner {

    private static final String BANNER = "////////////////////////////////////////////////////////////////////\n" +
                                        "//                          _ooOoo_                               //\n" +
                                        "//                         o8888888o                              //\n" +
                                        "//                         88\" . \"88                              //\n" +
                                        "//                         (| ^_^ |)                              //\n" +
                                        "//                         O\\  =  /O                              //\n" +
                                        "//                      ____/`---'\\____                           //\n" +
                                        "//                    .'  \\\\|     |//  `.                         //\n" +
                                        "//                   /  \\\\|||  :  |||//  \\                        //\n" +
                                        "//                  /  _||||| -:- |||||-  \\                       //\n" +
                                        "//                  |   | \\\\\\  -  /// |   |                       //\n" +
                                        "//                  | \\_|  ''\\---/''  |   |                       //\n" +
                                        "//                  \\  .-\\__  `-`  ___/-. /                       //\n" +
                                        "//                ___`. .'  /--.--\\  `. . ___                     //\n" +
                                        "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" +
                                        "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" +
                                        "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" +
                                        "//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" +
                                        "//                           `=---='                              //\n" +
                                        "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" +
                                        "//            佛祖保佑       永不宕机     永无BUG                 //\n" +
                                        "////////////////////////////////////////////////////////////////////";
    private static final String SERVER_INFO = "Application %s is running! Access URLs:\n\t" +
            "Local: \t\thttp://127.0.0.1:%s\n\t" +
            "External: \thttp://%s:%s\n\t" +
            "Profiles: \t%s\n";

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        String name = environment.getProperty("spring.application.name");
        String port = environment.getProperty("server.port");
        String httpPort = StringUtils.isBlank(port) ? "8080" : port;
        String hostAddress = "";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            hostAddress = "UN_KNOW";
        }
        String activeProfiles = StringUtils.join(environment.getActiveProfiles());
        String string = String.format(SERVER_INFO, name, httpPort, hostAddress, httpPort, activeProfiles);

        out.println();
        out.println(AnsiOutput.toString(AnsiColor.GREEN, BANNER));
        out.println();
        out.println(AnsiOutput.toString(AnsiColor.GREEN, string));
        out.println();
    }
}

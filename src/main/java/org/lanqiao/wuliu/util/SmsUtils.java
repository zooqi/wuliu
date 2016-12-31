package org.lanqiao.wuliu.util;

import java.util.List;

import com.shcm.bean.BalanceResultBean;
import com.shcm.bean.SendResultBean;
import com.shcm.send.DataApi;
import com.shcm.send.OpenApi;

/**
 * 发送短信公用类
 * 
 * @todo
 * @author
 * @date
 */
public class SmsUtils {

	public static void init() {
		String sOpenUrl = "http://smsapi.c123.cn/OpenPlatform/OpenApi";
		String sDataUrl = "http://smsapi.c123.cn/DataPlatform/DataApi";

		// 接口帐号
		final String account = "";
		// 接口密钥
		final String authkey = "";
		// 通道组编号
		final String sCgid = "5728";
		final String sCsid = "0";
		final int cgid = (new Integer(Integer.parseInt(sCgid))).intValue();
		// 默认使用的签名编号(未指定签名编号时传此值到服务器)
		final int csid = (new Integer(Integer.parseInt(sCsid))).intValue();
		// 发送参数
		OpenApi.initialzeAccount(sOpenUrl, account, authkey, cgid, csid);
		// 状态及回复参数
		DataApi.initialzeAccount(sDataUrl, account, authkey);
	}

	/**
	 * 获取余额
	 * 
	 * @return
	 */
	public static int getRemain() {
		// 获取帐户余额
		BalanceResultBean br = OpenApi.getBalance();
		if (br.getResult() < 1) {
			System.out.println("【获取可用余额失败】: " + br.getErrMsg());
			return 0;
		}
		return br.getRemain();
	}

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 * @param content
	 * @return
	 */
	public static List<SendResultBean> sendOnce(String mobile, String content) {
		return OpenApi.sendOnce(mobile, content, 0, 0, null);
	}

}

/**
 * 
 */
package org.lanqiao.wuliu.service.impl;

import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Expent;
import org.lanqiao.wuliu.dao.impl.ExpentDaoImpl;

/**
 * 支出业务层
 * 
 * @author 杨明静
 *
 */
public class ExpentSerciceImpl {
	ExpentDaoImpl edi = new ExpentDaoImpl();

	public int expInsert(Expent expent) {
		return edi.expInsert(expent);
	}
	
	public int expDelete(int expId){
		return edi.expDelete(expId);
	}
	
	public int expUpdate(int expId){
		return edi.expUpdate(expId);
	}
	
	public ArrayList<Expent> expSelect(int pageCurrentFirst, int pageRows,
			Expent expentReach){
		return expSelect(pageCurrentFirst, pageRows, expentReach);
	}
}

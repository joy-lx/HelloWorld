package com.cloudlife.util;

import java.io.IOException;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

public class CheckMobile {
	// \b �ǵ��ʱ߽�(���ŵ�����(��ĸ�ַ� �� ����ĸ�ַ�) ֮����߼��ϵļ��),    
    // �ַ����ڱ���ʱ�ᱻת��һ��,������ "\\b"    
    // \B �ǵ����ڲ��߼����(���ŵ�������ĸ�ַ�֮����߼��ϵļ��)    
    static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"    
            +"|windows (phone|ce)|blackberry"    
            +"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"    
            +"|laystation portable)|nokia|fennec|htc[-_]"    
            +"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";    
    static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"    
            +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";    
      
    //�ƶ��豸����ƥ�䣺�ֻ��ˡ�ƽ��  
    static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);    
    static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);    
        
    /** 
     * ����Ƿ����ƶ��豸���� 
     *  
     * @Title: check 
     * @Date : 2014-7-7 ����01:29:07 
     * @param userAgent �������ʶ 
     * @return true:�ƶ��豸���룬false:pc�˽��� 
     */  
    public static boolean check(String userAgent){    
        if(null == userAgent){    
            userAgent = "";    
        }    
        // ƥ��    
        Matcher matcherPhone = phonePat.matcher(userAgent);    
        Matcher matcherTable = tablePat.matcher(userAgent);    
        if(matcherPhone.find() || matcherTable.find()){    
            return true;    
        } else {    
            return false;    
        }    
    }  
    
    public static boolean check(HttpServletRequest request,HttpServletResponse response) throws IOException
	{  
	    boolean isFromMobile=false;
	      
	    HttpSession session= request.getSession();  
	//����Ƿ��Ѿ���¼���ʷ�ʽ���ƶ��˻�pc�ˣ�  
	    if(null==session.getAttribute("ua")){  
	        try{  
	            //��ȡua�������ж��Ƿ�Ϊ�ƶ��˷���  
	            String userAgent = request.getHeader( "USER-AGENT" ).toLowerCase();    
	            if(null == userAgent){    
	                userAgent = "";    
	            }  
	            isFromMobile=check(userAgent);  
	            //�ж��Ƿ�Ϊ�ƶ��˷���  
	            if(isFromMobile){  
	                System.out.println("�ƶ��˷���");  
	                session.setAttribute("ua","mobile");  
	            } else {  
	                System.out.println("pc�˷���");  
	                session.setAttribute("ua","pc");  
	            }  
	        }catch(Exception e){}  
	    }else{  
	        isFromMobile=session.getAttribute("ua").equals("mobile");  
	    }  
	      
	    return isFromMobile;  
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regex;

/**
 *
 * @author ltuan
 */
public class RegexHelper {
    public static boolean regexCustomerName(String name) {
        String firstLetter="[A-EGHIK-VXYÂĐỔÔÚỨ]";
      	String otherLetters="[a-eghik-vxyàáâãèéêìíòóôõùúýỳỹỷỵựửữừứưụủũợởỡờớơộổỗồốọỏịỉĩệểễềếẹẻẽặẳẵằắăậẩẫầấạảđ₫]";
      	String regexString="^"
                 +firstLetter+otherLetters+"+\\s"
                 +"("+firstLetter+otherLetters+"+\\s)*"
                 +firstLetter+otherLetters+"+$";
        
        return name.matches(regexString);
    }
    public static boolean regexDeviceName(String name) {
        String firstLetter="[A-EGHIK-VXYÂĐỔÔÚỨ]";
        String firstLetter1="[a-eghik-vxyâđổôúứ]";
      	String otherLetters="[a-eghik-vxyàáâãèéêìíòóôõùúýỳỹỷỵựửữừứưụủũợởỡờớơộổỗồốọỏịỉĩệểễềếẹẻẽặẳẵằắăậẩẫầấạảđ₫]";
      	String regexString="^"
                 +firstLetter+otherLetters+"+\\s"
                 +"("+firstLetter1+otherLetters+"+\\s)*"
                 +firstLetter1+otherLetters+"+$";        
        return name.matches(regexString);
    }
    
    public static boolean regexPhoneNumber(String number) {
        String regex = "^((09(\\d){8})|(08(\\d){8})|(03(\\d){8})|(07(\\d){8})|(05(\\d){8}))$";
        return number.matches(regex);
    }
    
    public static boolean regexCMND(String number) {
        String regex = "[0-9]{9}";
        return number.matches(regex);
    }
    
    public static boolean regexEmail(String email) {
        String regex = "\\w+.@\\w+.\\w{2,5}";
        return email.matches(regex);
    }
    
}

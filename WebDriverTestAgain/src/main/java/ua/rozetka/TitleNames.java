package ua.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum TitleNames {
	MAINPAGE("��������-������� ROZETKA�: �����������, ������������, ������������, ���������� � ������������ �������������"),
    
	SMARTPAGE("��������, �� � ����������� - Rozetka.ua | ������ ��������, �� � ����������� � �����: ����, ������, �������");	
	
	private final String text;

	    /**
	     * @param text
	     */
		private TitleNames(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
}

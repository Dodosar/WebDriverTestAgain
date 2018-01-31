package ua.rozetka;

public enum TitleNames {
	MAINPAGE("Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие"),
    
	SMARTPAGE("Смартфони, ТВ і електроніка - Rozetka.ua | Купити Смартфони, ТВ і електроніка у Києві: ціна, відгуки, продаж");	
	
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

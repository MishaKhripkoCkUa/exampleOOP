import java.util.ArrayList;

public class TagHTML {
	ArrayList <String> list = new ArrayList<String>();
	private String attributes = "";
	private String innerHTML = "\n";
	private String nameTag = "";
	protected void initlistAttributes (){
		list.add("accesskey");
		list.add("class");
		list.add("contenteditable");
		list.add("contextmenu");
		list.add("dir");
		list.add("hidden");
		list.add("id");
		list.add("lang");
		list.add("spellcheck");
		list.add("style");
		list.add("tabindex");
		list.add("title");
		list.add("xml:lang");
	}
	public TagHTML (String nameT){
		nameTag = nameT.toLowerCase();
		initlistAttributes();
	}
	public TagHTML (String nameT, TagHTML tag){
		nameTag = nameT.toLowerCase();
		innerHTML = tag.toString();
		initlistAttributes();
	}
	protected boolean setAttributes(String setAtr){
		boolean checkReturn = false;
		for (int i = 0 ; i < list.size(); i++){
			if (setAtr.contains(list.get(i))){
				int indexOfAtr = setAtr.indexOf(list.get(i)) + list.get(i).length();
				boolean changeAtr = false;
				int j = 0;
				int[] positionchangeAtr = new int[2];
				int rule = 0; //Количество соблюденных правил должно быть == 3. (согласно синтаксису HTML) 
				/*
				 * 1.) после указания атрибута должен быть знак "=".
				 * 2.) после знака "=" должно быть начало и конец свойства атрибута под знаком ' " ';
				 * 
				 */
				while (!changeAtr && j <64){
					// Если текст изначально не правильный, счетчик j завершит цикл после 64 итераций.
					++indexOfAtr;j++;
					if (setAtr.charAt(indexOfAtr) == " ".charAt(0)){ 
						/*Если первый символ после атрибута это пробел то переход к 
						 * след. символу (след. итерация).
						 */
						continue;
					}
					else
						if (setAtr.charAt(indexOfAtr) == "=".charAt(0)){
							rule++; //Первое правило истинное.
						} else
							if (setAtr.charAt(indexOfAtr) == "'".charAt(0)){
								rule++; //Второе и в следствии третье правило может быть истинным.
								if (rule == 2) positionchangeAtr[0] = indexOfAtr+1;
								if (rule == 3) {
									positionchangeAtr[1] = indexOfAtr;
									changeAtr = true;
								}
							}
					if(changeAtr){ //добавляет проверенные атрибуты в свойство attributes
						attributes += list.get(i) + " = '" + setAtr.substring(positionchangeAtr[0], positionchangeAtr[1]) + "' ";
						checkReturn = true;
					}
					
				}
			}
		}
		return checkReturn;
	}
	public void setInnerHTML(String iHTML){
		innerHTML = iHTML;
	}
	@Override
    public String toString() {
        return "<" + nameTag + " " + attributes.trim() + ">\n" + innerHTML + "\n</" + nameTag + ">";
    }
}
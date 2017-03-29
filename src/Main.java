public class Main {
	public static void main(String[] args) {
	TagHTML tag = new TagHTML("body"); // Передаем имя тега для объекта.
	tag.setAttributes("class = 'newClass' title = 'Text'"); 
	/* В объекте tag содержатся 13 типов атрибутов, именуемые как универсальные в объекте list;
	 * Список универсальных атрибутов: http://htmlbook.ru/html/attr/common
	 * TagHTML - это родительский класс.
	 */
	
	Div div = new Div("div");
	/* Создаётся чилд-объект тег div. Он содержится в себе на 1 атрибут больше и является дочерним класса TagHTML
	 * как в ООП так и в DOM-дереве наяву. 
	 * Как-то так я себе представил наследование.
	 */
	if (div.setAttributes("align = 'center'")){
		tag.setInnerHTML(div.toString());
	}
	
	System.out.println(tag.toString());
	}
}

public class Div extends TagHTML{
	public Div (String nameTag, TagHTML tag){
		super(nameTag, tag);
		addAttribute();
	}
	public Div (String nameTag){
		super(nameTag);
		addAttribute();
	}
	private void addAttribute (){
		list.add("align");
	}
	public void addAttribute (String attribute){
		list.add(attribute.trim());
	}
}
/* Есть класс предок TagHTML который содержит определенные атрибуты. Можно было бы сделать всё в одном классе,
 * но тогда алгоритм проверки был бы сложнее и, он бы не выполнял ту роль которую может выполнить эта конструкция.
 * Я задумывал это в качестве создания программы в которой может быть включена иерархия тегов-объектов по отношению
 * к их атрибутам. 
 * 
 * 
 */
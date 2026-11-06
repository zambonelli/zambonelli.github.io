class List implements Serializable {
	Object e;	List next;
	public List() {e=null; next=null; }
	public Object head() { return e; }
	public List tail() { return next; }
	public List cons(Object e) {
		List nl = new List();
		nl.e = e; nl.next = this; return nl;
	}
}

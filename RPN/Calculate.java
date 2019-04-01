package RPN;

import Stack.ArrayStack;

public class Calculate {

	private static final char END_OF_TOKEN = '$';
	private ArrayStack<Character> _oStack;
	private ArrayStack<Double> _vStack;
	private char[] _infix;
	private char[] _postfix;

	private ArrayStack<Character> getOStack() {
		return _oStack;
	}

	private void setOStack(ArrayStack<Character> _oStack) {
		this._oStack = _oStack;
	}

	private ArrayStack<Double> getVStack() {
		return _vStack;
	}

	private void setVStack(ArrayStack<Double> _vStack) {
		this._vStack = _vStack;
	}

	private char[] getInfix() {
		return _infix;
	}

	private void setInfix(char[] _infix) {
		this._infix = _infix;
	}

	private char[] getPostfix() {
		return _postfix;
	}

	private void setPostfix(char[] _postfix) {
		this._postfix = _postfix;
	}

	public Calculate() {
		setOStack(null);
		setVStack(null);
		setInfix(getInfix());
		setPostfix(getPostfix());

	}

	public void setInfix(String newInfix) {
		setInfix(newInfix.toCharArray());
	}

	public String infix() {
		return String.valueOf(getInfix());
	}

	public String postfix() {
		return String.valueOf(getPostfix());
	}

	private boolean isDigit(char aToken) {
		return ((int) aToken >= 0 && (int) aToken <= 9);
	}

	private int inComingPrecedence(char aToken) {
		// 현재스택에들어가야하는연산자aToken 의우선순위값을돌려준다.
		int priority = 0;
		switch (String.valueOf(aToken)) {
		case "+":
		case "-":
			priority = 1;
			break;
		case "*":
		case "/":
		case "%":
			priority = 2;
			break;
		case "$":
			priority = 0;
			break;
		default:
			priority = -1;
			break;
		}
		return priority;
	}

	private int inStackPrecedence(char aToken) {
		return inComingPrecedence(aToken); // 위에꺼랑 똑같은거같은데 실습과제에 있길래 함.

	}

	/*
	 * private void showOstackAll() { System.out.print("Ostack: "); for (int
	 * index = 0; index < getOStack().size(); index++) {
	 * System.out.print(getOStack().get(index) + " "); } System.out.println(); }
	 * 
	 * private void showVstackAll() { System.out.print("Vstack: "); for (int
	 * index = 0; index < getVStack().size(); index++) {
	 * System.out.print(getVStack().get(index) + " "); } System.out.println(); }
	 */

	public boolean infixToPostFix() {
		// infix를 postfix로
		int ifix = 0;
		int pfix = 0;
		char currentToken, poppedToken, topToken;

		setOStack(new ArrayStack<Character>(getInfix().length));
		setPostfix(new char[getInfix().length + 1]);

		// infix 다 없앨 때까지 반복해
		while (ifix < getInfix().length) {

			// currentToken에 infix값 계속 불러와 + 불러온다음 index+1해줘
			currentToken = getInfix()[ifix++];

			// 숫자면 바로 postfix에 저장해
			if (isDigit(currentToken)) {
				getPostfix()[pfix++] = currentToken;
			}
			// 숫자 아니면 어떻게 해야겠어? 일단 경우 나눠야지
			else {
				// 1번 ')'이거면 OStack에 저장된 수식 '('나올 때까지 다 pop해 여기서 괄호는 stack에 저장해도 postfix에 저장하면 안되겠지.
				if (currentToken == ')') {
					if (!getOStack().isEmpty()) { // OStack에 수식이 들어있는지 판별해
						poppedToken = (char) getOStack().pop(); //수식이 들어있으면 pop시키고 pop된 거 poppedToken에 저장해
					} else
						return false; // 비어있다는건 '('이게 없다는 거니까 수식 잘못된거야.

					while (poppedToken != '(') { // poppedToken에 '('가 저장될 때까지 반복해
						getPostfix()[pfix++] = poppedToken; // 뭐를? pop된거 postfix에 저장해
						if (!getOStack().isEmpty()) { // OStack에 수식이 들어있는지 판별해
							poppedToken = (char) getOStack().pop(); // 수식이 있으면 pop시키고 pop된 거 poppedToken에 저장해 '('나올 때까지
						} else
							return false; // '(' 이거 안나오면 수식 잘못된거야.
					}
				}
				// 이제 2번이야. 괄호가 아닌 경우야
				else {
					// 우선순위 따져야겠지? incomingP가 들어온 수식(=currentToken) 우선순위야.
					int inComingP = this.inComingPrecedence(currentToken);
					if (!getOStack().isEmpty()) { // OStack에 수식이 들어있는지 판별해
						topToken = (char) getOStack().peek(); // 수식이 있으면 peek해서 topToken에 저장해. OStack의 top이겠지.
						while (this.inStackPrecedence(topToken) >= inComingP) { // topToken 우선순위랑 inComingP 비교해서 inComingP 우선순위가 높아질 때까지 반복이야.
							poppedToken = (char) getOStack().pop(); // incomingP가 낮으니까 OStack에서 pop해
							getPostfix()[pfix++] = poppedToken; // pop한거 Postfix에 저장해
							if (!getOStack().isEmpty()) // OStack에 수식 남아 있는지 판별해
								topToken = (char) getOStack().peek(); // 수식 남아있으면 peek해서 topToken에 저장해. 그리고 while문 다시 가겠지?
							else
								break; // OStack에 수식 없으면 while문 나와.
						}
					}
					// 수식 없으면 currentToken OStack에 저장해
					getOStack().push(currentToken);
				}
			}

		}
		// 이제 infix postfix로 다 바뀌었겠지. postfix에 END_OF_TOKEN 저장해.
		getPostfix()[pfix++] = Calculate.END_OF_TOKEN;
		return true; // 끝
	}

	public double evalPostfix() {
		
		int index = 0;
		char curToken;
		setVStack(new ArrayStack<Double>(getPostfix().length));
		double result = 0;
		
		
		curToken = getPostfix()[index++]; //curToken에 postfix 첫번째 꺼 저장하고 index+1해줘.
		while (curToken != Calculate.END_OF_TOKEN) { //curToken이 END_OF_TOKEN일 때까지 반복해.
			if (this.isDigit(curToken)) { //숫자면 curToken VStack에 저장해.
				getVStack().push((double)curToken);
			}
			else { //수식이면 pop두번해서 x, y에 저장해
				double y = (double) getVStack().pop();
				double x = (double) getVStack().pop();
				double z = 0;
				switch (String.valueOf(curToken)) { //switch문으로 그에 맞는 수식 해줘서 z에 저장해.
			        case "+":
			        	z = x+y;
			        	break;
			        case "-":
			        	z = x-y;
				        break;
			        case "*":
			        	z = x*y;
			    	    break;
			        case "/":
			        	z = x/y;
			        	break;
	    		    case "%":
		    	    	z = x%y;
	    		    	break;
	    		    default:
	    		    	break;
	    		}
				getVStack().push(z); //z를 그다음 VStack에 저장해.
			}
			curToken = getPostfix()[index++]; //curToken 최신화
		}
		//END_OF_TOKEN이면 VStack에 결과값인 숫자 하나만 남겠지. 
		result = getVStack().pop(); //그걸 result값에 저장해주고
		return result; //리턴해.
	}
}

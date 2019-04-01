package week_03;

public class MagicSquare {

	int matrix[][]; // 마방진 틀
	int row; // 행 값
	int column; // 열 값
	int number; // 마방진에 입력할 숫자
	int size; // 마방진 크기 size*size로 만듬
	int maxNum; // Number의 최댓값

	// 각 변수의 getter setter 설정
	private int[][] getMatrix() {
		return matrix;
	}

	private void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	private int getRow() {
		return row;
	}

	private void setRow(int row) {
		this.row = row;
	}

	private int getColumn() {
		return column;
	}

	private void setColumn(int column) {
		this.column = column;
	}

	private int getNumber() {
		return number;
	}

	private void setNumber(int number) {
		this.number = number;
	}

	private int getSize() {
		return size;
	}

	private void setSize(int size) {
		this.size = size;
	}

	private int getMaxNum() {
		return maxNum;
	}

	private void setMaxNum(int max) {
		maxNum = max;
	}

	// 생성자 = 각 변수 초기화
	public MagicSquare(int size) {
		this.setMatrix(new int[size][size]); // size*size크기의 2차원 배열 생성
		this.setSize(size - 1); // size를 편하게 부르기 위해 index는 1이 작기때문에 1빼서 저장
		this.setNumber(1); // 처음 입력할 수인 1 저장
		this.setColumn(getSize() / 2); // 처음 입력할 열은 중간의 열이므로 size 2로 나눈 값 저장
		this.setRow(getSize()); // 처음 입력할 행은 마지막 행이므로 size 값 저장
		this.setMaxNum(size * size); // size*size를 저장해서 사용하기 위한 변수이므로 그 값을 저장
	}

	// Matrix의 [cNum][rNum]이 비어있는지 확인해주는 함수
	// 편의를 위해 만들었습니다.
	private boolean isempty(int cNum, int rNum) {
		if (getMatrix()[cNum][rNum] == 0)
			return true;
		else
			return false;
	}

	// 다음 입력해줄 index가 비어있는지 확인해주는 함수
	// 편의를 위해 만들었습니다.
	private boolean VerifyEmpty() {
		// 필드의 column과 row를 보호 하기 위해 값을 따로 저장
		int cNum = getColumn();
		int rNum = getRow();
		// column이 영역밖이면 0으로 해주고 아니면 +1해줌
		if (cNum + 1 > getSize())
			cNum = 0;
		else
			cNum += 1;
		// row가 영역밖이면 0으로 해주고 아니면 +1해줌
		if (rNum + 1 > getSize())
			rNum = 0;
		else
			rNum += 1;
		// 비어있으면 column값고 row값을 최신화 시켜주고
		// true리턴
		if (isempty(cNum, rNum)) {
			setColumn(cNum);
			setRow(rNum);
			return true;
		}
		// 비어있지 않으면 false리턴
		else
			return false;
	}

	// 입력할 index에 number값을 입력하고, number++해주는 함수
	// 편의를 위해 만들었습니다.
	private void InputNum() {
		// 입력할 index에 number값을 입력
		getMatrix()[getColumn()][getRow()] = getNumber();
		// number++
		setNumber(getNumber() + 1);
	}

	// 마방진 숫자를 입력하는 함수
	public void make() {
		// 처음으로 아랫줄 가운데 숫자 1 입력 후 number++
		InputNum(); // 생성자에서 행렬 값을 정해줬기 때문에 바로 입력
		// 입력할 수가 maxNum보다 작거나 같을 때 반복
		while (getNumber() <= getMaxNum()) {
			// 다음 입력할 값이 비어있으면
			// number값을 입력하고, number++
			if (VerifyEmpty()) {
				InputNum();
			}
			//비어있지 않으면 한칸 위에
			//number값을 입력하고, number++
			else {
				setRow(getRow() - 1);
				InputNum();
			}
		}
	}
	//마방진을 print해주는 함수
	public void print() {
		//row가 size보다 작거나 같을 때 반복
		for (int rNum = 0; rNum <= getSize(); rNum++) {
			//column이 size보다 작거나 같을 때 반복
			for (int cNum = 0; cNum <= getSize(); cNum++) {
				//print!
				System.out.print(getMatrix()[cNum][rNum] + "\t");
			}
			//row 하나를 출력하면 한칸 띄어 씀
			System.out.println();
		}
	}
	//마방진의 column의 합 리턴하는 함수
	public int sumColumn(int column) {
		int result = 0; //초기 result값 0
		//row가 size보다 작거나 같을 때 반복
		for (int rNum = 0; rNum <= getSize(); rNum++) {
			//result에 더해줌
			result += getMatrix()[column][rNum];
		}
		//result 값 리턴
		return result;
	}
	//마방진의 row의 합 리턴하는 함수
	public int sumRow(int row) {
		int result = 0; //초기 result값 0
		//column이 size보다 작거나 같을 때 반복
		for (int cNum = 0; cNum <= getSize(); cNum++) {
			//result에 더해줌
			result += getMatrix()[cNum][row];
		}
		//result 값 리턴
		return result;
	}
	//마방진의 대각선 합 리턴하는 함수
	public int sumDiagonal() {
		int result = 0; //초기 result값 0
		//num이 size보다 작거나 같을 때 반복
		for (int Num = 0; Num <= getSize(); Num++) {
			//result에 더해줌
			result += getMatrix()[Num][Num];
		}
		//result 값 리턴
		return result;
	}

}

package clientManage;

public class GameIdManage {

	public static final int CLIENT_MAX_NUM = 1000;
	public static final int TABLE_MAX_NUM = 500;
	public static final int TABLE_SET_MAX_NUM = 4;

	private int clientNum = 0;
	private int tableNum = 0;

	private boolean[][] tableIdList;
	private ClientMode[] clientIdList;

	public GameIdManage() {
		tableIdList = new boolean[TABLE_MAX_NUM][TABLE_SET_MAX_NUM];
		clientIdList = new ClientMode[CLIENT_MAX_NUM];
	}

	public int getClientId(String address,int recePort) {
		for (int i = 0; i < CLIENT_MAX_NUM; i++) {
			if (clientIdList[i]==null) {
				clientIdList[i] = new ClientMode(i,address,recePort);
				clientNum++;
				return i;
			}
		}
		return -1;
	}

	public void removeClientId(int clientId) {
		if (clientId < CLIENT_MAX_NUM && clientId > 0) {
			clientIdList[clientId] = null;
			clientNum--;
		}
	}

	public int joinTable(int tableId) {
		if (tableIdList[tableId][0]) {
			for (int i = 1; i < TABLE_SET_MAX_NUM; i++) {
				if (!tableIdList[tableId][i])
					return i;
			}
			return -2;
		}
		return -1;
	}

	public void leaveTable(int tableId, int setId) {
		if (tableId < TABLE_MAX_NUM && tableId > 0 && setId < TABLE_SET_MAX_NUM
				&& setId > 0) {
			tableIdList[tableId][setId] = false;
		}
	}

	public void showInfor() {
		System.out.print("ClientNum: " + clientNum);
		System.out.println("TableNum: " + tableNum);
	}

	public int getClientNum() {
		return clientNum;
	}

	public int getTableNum() {
		return tableNum;
	}

	// private int[][] gameID = new int[homeNumber + 1][setNumber + 1];
	// private int[] clientIdList = new int[clientMaxNum];
	//
	// public int getHomeNumber() {
	// return homeNumber;
	// }
	//
	// public int getSetNumber() {
	// return setNumber;
	// }
	//
	// public int getClientMaxNum() {
	// return clientMaxNum;
	// }
	//
	// public GameIDManage() {
	// }
	//
	// public void displayIdList() {
	// for (int i = 0; i < 10; i++) {
	// System.out.print(clientIdList[i] + " ");
	// }
	// System.out.println();
	// }
	//
	// public void displayGameId() {
	// for (int i = 0; i <= homeNumber; i++) {
	// for (int j = 0; j <= setNumber; j++) {
	// System.out.print(gameID[i][j] + " ");
	// }
	// System.out.println();
	// }
	// }
	//
	// public void nameListNorms(int flag) {
	// if (flag == 0) {
	// for (int i = 0; i <= clientMaxNum; i++) {
	// clientIdList[i] = 0;
	// }
	// } else {
	// int count = 0;
	// for (int i = 1; i <= clientMaxNum; i++) {
	// if (clientIdList[i] != 0) {
	// count++;
	// }
	// }
	// clientIdList[0] = count;
	// }
	// }
	//
	// public void gameIDNorms(int flag) {
	// if (flag == 0) {
	// for (int i = 0; i <= homeNumber; i++) {
	// for (int j = 0; j <= setNumber; j++) {
	// gameID[i][j] = 0;
	// }
	// }
	// } else {
	// for (int i = 1; i <= homeNumber; i++) {
	// int count = 0;
	// for (int j = 1; j <= setNumber; j++) {
	// if (gameID[i][j] != 0) {
	// count++;
	// }
	// }
	// gameID[i][0] = count;
	// }
	// }
	// }
	// public int getIdNumber(){
	// return clientIdList[0];
	// }
	//
	// public int getGameIDNumber(int homeID){
	// return gameID[homeID][0];
	// }
	//
	// public int getClientId() {
	// if (clientIdList[0] >= clientMaxNum) {
	// return 0;
	// }
	// for (int i = 1; i < clientMaxNum; i++) {
	// if (clientIdList[i] == 0) {
	// clientIdList[0]++;
	// clientIdList[i]=1;
	// return i;
	// }
	// }
	// return 0;
	// }
	//
	// public int getGameID(int homeID) {
	// if (homeID == 0) {
	// return 0;
	// } else {
	// int i;
	// for (i = 1; i <= setNumber; i++) {
	// if (gameID[homeID][i] == 0) {
	// gameID[homeID][i] = 1;
	// gameID[homeID][0]++;
	// return i;
	// }
	// }
	// if (i == setNumber+1) {
	// return 0;
	// }
	// }
	// return 0;
	// }
	//
	// public boolean removeGameID(int home, int set) {
	// if (gameID[home][set] == 0) {
	// return false;
	// }
	// gameID[home][set] = 0;
	// gameID[home][0]--;
	// return true;
	// }
	//
	// public boolean removeName(int index) {
	// if (index > clientMaxNum) {
	// return false;
	// }
	// else if (clientIdList[index] == 0) {
	// return false;
	// } else {
	// clientIdList[index] = 0;
	// clientIdList[0]-=1;
	// return true;
	// }
	// }
}

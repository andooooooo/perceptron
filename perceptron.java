import java.util.Random;

public class percep {
	public static void main (String[] args) {

	//正例不例の設定
	int a1[] = {1,1,2};
	int a2[] = {1,2,4};
	int a3[] = {1,4,2};
	int b1[] = {1,8,4};
	int b2[] = {1,6,8};
	int b3[] = {1,7,7};
	int omomi[] = {0,0,0}; //重みベクトル
	int collect = 0; //正解を重ねたらループをやめる関数
	int seifurei = 0; //階段関数
	int[] naiseki = new int[3]; //内積値の保存
	int kekka = 0;
	int hantei = 0;
	int roop = 0;
	int[] x = new int[3];
	Random r = new Random();
	String rei = "";
	String hanteikekka = "";

	for(int i=0;i<200;i++){
		int ram = r.nextInt(6);

		//ランダムで例選択をする
		if(ram == 0){
			for(int g=0;g<3;g++){
				x[g] = a1[g];
			}
			rei = "正例１";
		}else if(ram == 1){
			for(int g=0;g<3;g++){
				x[g] = a2[g];
			}
			rei = "正例２";
		}else if(ram == 2){
			for(int g=0;g<3;g++){
				x[g] = a3[g];
			}
			rei = "正例３";
		}else if(ram == 3){
			for(int g=0;g<3;g++){
				x[g] = b1[g];
			}
			rei = "不例１";
		}else if(ram == 4){
			for(int g=0;g<3;g++){
				x[g] = b2[g];
			}
			rei = "不例２";
		}else if(ram == 5){
			for(int g=0;g<3;g++){
				x[g] = b3[g];
			}
			rei = "不例３";
		}
		if(ram <=3){
			seifurei = 1;
		}else{
			seifurei = -1;
		}
		//内積の計算
		naiseki[0] = x[0]*omomi[0];
		naiseki[1] = x[1]*omomi[1];
		naiseki[2] = x[2]*omomi[2];
		kekka = naiseki[0]+naiseki[1]+naiseki[2];
		if(kekka<0){
			hantei = -1;
		}else{
			hantei = 1;
		}
		if(hantei==seifurei){
			collect = collect+1;
			hanteikekka = "正解";
			System.out.println("ループ" + (i+1) +"回め。選んだ例は" + rei + "。判定は" + hanteikekka + "。只今の重みベクトルは(" + omomi[0] + "," + omomi[1] + "," + omomi[2] + ")です。");
			if(collect==6){
				roop = i;
				break;
			}else{
				continue;
			}
		}else{
			if(seifurei==-1){
				omomi[0] = omomi[0]-x[0];
				omomi[1] = omomi[1]-x[1];
				omomi[2] = omomi[2]-x[2];
				collect = 0;
				hanteikekka = "不正解";
			}else{
				omomi[0] = omomi[0]+x[0];
				omomi[1] = omomi[1]+x[1];
				omomi[2] = omomi[2]+x[2];
				collect = 0;
				hanteikekka = "不正解";
			}
		}

		System.out.println("ループ" + (i+1) +"回め。選んだ例は" + rei + "。判定は" + hanteikekka + "。只今の重みベクトルは(" + omomi[0] + "," + omomi[1] + "," + omomi[2] + ")です。");

	}
	System.out.println("終わりました。総ループ回数は" + (roop+1) + "回。最終的な重みベクトルは(" + omomi[0] + "," + omomi[1] + "," + omomi[2] + ")でした。" );
	System.out.println("分離直線は" + omomi[2] + "y+" + omomi[1] + "x+" + omomi[0] + "=0です。");

	}
}

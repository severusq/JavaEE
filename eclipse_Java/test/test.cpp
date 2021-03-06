#include "hash_func.c"
#include "AES128.c"
#include "hash_func.h"
#include <iostream>
#include <cstdlib>
#include <cctype>
#include <cstring>
#include <string>

using namespace std;

typedef unsigned int u32;

void sha1_array(string a, u32* w) //SHA1输入分组
{
	u32 num = a.length() / 8;
	//cout << "a=" << a << endl;
	for (u32 i = 0, j = 0; i < num; j += 8, i++)
	{
		string b(a.begin() + j, a.begin() + j + 8); //每次取出8位，转换为10进制整数
		w[i] = strtoll(b.c_str(), NULL, 16);
		//if (i == num - 1) cout << endl << "b=" << b << endl;
	}
	//cout << "w[num]=" << num << " " << w[num-1] << endl;
	u32 c = (512 - num * 32) / 32; //还要补多少个32bit
	for (u32 i = 0, j = num; i < c; i++, j++)
	{
		if (j == num) w[j] = 2147483648; //先补一个1再补31个0
		else if (i < c - 1) w[j] = 0; //除了最后32bit其余都为0
		else w[j] = a.length() * 4; //最后32bit为明文长度
	}
}

//string DecIntToHexStr(u32 num)
//{
//	string str;
//	long long Temp = num / 16;
//	int left = num % 16;
//	if (Temp > 0)
//		str += DecIntToHexStr(Temp);
//	if (left < 10)
//		str += (left + '0');
//	else
//		str += ('a' + left - 10);
//
//	//cout << "string=" << str << endl;
//	return str;
//}
#include <sstream>
//#include <string>
std::string dec2hex(int i, int width) //十进制转换为16进制字符串
{
	std::stringstream ioss; //定义字符串流
	std::string s_temp; //存放转化后字符
	ioss << std::hex << i; //以十六制形式输出
	ioss >> s_temp;
	std::string s(width - s_temp.size(), '0'); //补0
	s += s_temp; //合并
	return s;
}
//static const char base64_back[128] =
//{
//	-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
//	-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
//	-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
//	52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1,  0, -1, -1,
//	-1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
//	15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
//	-1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
//	41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
//};
//void base64_decrypt(const char * cbuf, char * pbuf)
//{
//	int temp = 0;
//	for (int i = 0; i<4; i++) {//反向索引，根据编码求得原index并进行移位异或
//		temp |= base64_back[cbuf[i]] << (18 - 6 * i);//temp的高1byte未使用
//	}
//	for (int i = 0; i<3; i++) {//移位异或得到的temp的低三byte分别为原有三个byte
//		pbuf[i] = (temp >> (16 - i * 8)) & 0XFF;
//	}
//}
//void base64_decrypt_text(const char * cbuf, char* pbuf, string& s, int clen)
//{
//	int plen = clen / 4;
//
//	pbuf = (char *)malloc(plen * 3);
//
//	if (NULL == pbuf) {
//		exit(EXIT_FAILURE);
//	}
//	memset(pbuf, 0, plen * 3);
//
//	for (int i = 0; i < plen; i++) {
//		base64_decrypt(&cbuf[i * 4], &pbuf[i * 3]);
//	}
//	for (int i = 0; i < plen * 3; i++) s.append(dec2hex(int(pbuf[i]), 2));
//	//show_base64(pbuf, plen * 3);
//}
#include <iostream>
#include<stdio.h>
//#include"cdecode.h"
#include<string.h>
#include <stdlib.h>
#include <assert.h>

//#define SIZE 100
//
//extern int base64_decode_block(const char* code_in, const int length_in, char* plaintext_out, base64_decodestate* state_in);
//extern int base64_decode_value(char value_in);
//extern void base64_init_decodestate(base64_decodestate* state_in);
///* run this program using the console pauser or add your own getch, system("pause") or input loop */
//char* decode(const char* input)
//{
//
//	char* output;
//	char* c = output = (char*)malloc(SIZE);
//	int cnt = 0;
//	base64_decodestate s;
//	base64_init_decodestate(&s);
//	cnt = base64_decode_block(input, strlen(input), c, &s);
//	c += cnt;
//	*c = 0;
//	return output;
//}
u32 swap32(unsigned int a) //位反转操作
{
	u32 res = 0; //初始化结果为0
	int b = 1;
	for (int i = 0; i < 32; i++) //从低位扫描到高位
	{
		b <<= i; //b左移i位后与a做或运算，如果不为0则说明a的第i位为1
		int c = a | b;
		if (c != 0) { //如果发现a的第i位不为0
			int d = 1;
			d <<= 32 - i;
			res |= d; //res的第32-i位置为1
		}
	}
	return res;
}
int main()
{
	string salt("c97d2b037445a85dcf6b682af7b09bf2"); //初始化salt等提取的参数
	string VerifierHashInput("72f959ec5129204d875d3290ede137ce");
	string verifierHashValue("82dc08cc0ba3458cb2dbb8a5ec34441ca8945b1c790634ae6f075907b72d843f");

	u32 w[16];

	u32 salt_1[4]; //将salt值转换为十进制存储，方便以后的亦或操作
	for (int i = 0; i < 4; i++)
	{
		salt_1[i] = w[i];
	}

	u32 digest[5] = { sha1_constants_t{ SHA1M_A }, sha1_constants_t{ SHA1M_B }, //初始化SHA1输入的五个常量H0-H4
		sha1_constants_t{ SHA1M_C }, sha1_constants_t{ SHA1M_D }, sha1_constants_t{ SHA1M_E } };

	u32 copy_digest[5]; //复制一份H0-H4的值，方便以后复用
	for (int i = 0; i < 5; i++)
	{
		copy_digest[i] = digest[i];
	}

	for (u32 pwd = 0; pwd <= 999; pwd++) //遍历所有的密码组合
	{

		string password;
		string salt_pwd(salt);
		password.append(dec2hex(pwd, 3));
		salt_pwd.append(password);
		salt_pwd.append("f0000"); //salt+pwd预处理，储存在salt_pwd中
		//cout << salt_pwd;

		sha1_array(salt_pwd, w); //第一步的SHA1输入分组，分成16个32bit的u32数组
		//for (int k = 0; k < 16; k++) cout << "w=" << w[k] << endl;


		sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //第一次SHA1运算，输出保存在copy_digest中
		//for (int k = 0; k < 5; k++) cout << "digest=" << copy_digest[k] << endl;

		//w[0] = 0; //进入10万次迭代，输入分组，第一轮迭代计数器为0
		//for (u32 i = 1; i <= 5; i++) //第一步的SHA1输出作为10万次迭代的输入
		//{
		//	w[i] = copy_digest[i];
		//}
		//for (u32 i = 0, j = 6; i < 10; i++, j++) //SHA1输入分组
		//{
		//	if (j == 6) w[j] = 2147483648; //先补1再补0，因此储存1后面跟31个0的整数
		//	else if (i < 10) w[j] = 0; //除了末尾的32位其余都补0
		//	else w[j] = 192; //末尾的32位储存明文长度192
		//}

		u32 counter = 0; //计数器
		u32 num = (512 - 192) / 32; //计算，因为明文是192bit所以要补10个32bit

		for (int iter = 0; iter < 100000; iter++) //10万次迭代
		{
			w[0] = swap32(counter); //位反转，作为下一次输入的最初的32位
			for (u32 i = 1; i <= 5; i++) //输出作为输入，输出保存在copy_digest中
			{
				w[i] = copy_digest[i - 1]; //w的1-5置为上一次SHA1的输出，构成counter+上一次输出的输入
			}
			for (u32 i = 0, j = 192 / 32; i < num; i++, j++) //补足其它的位
			{
				if (j == 6) w[j] = 2147483648; //1后面接31个0的整数
				else if (i < num - 1) w[j] = 0; //除了最后一个32位其余都是0
				else w[j] = 192; //最后32比特值为明文长度192
			}

			for (int i = 0; i < 5; i++)
			{
				copy_digest[i] = digest[i]; //SHA1常量，H0-H4
			}
			counter++; //计数器加一

			sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //SHA1迭代
		}

		for (u32 i = 0; i < 5; i++)
		{
			w[i] = w[i + 1]; //最后一次迭代时也做了分组，因此实际输出是w的1-5，保存为0-4
		}
		//for (int k = 0; k < 16; k++) cout << "final w=" << w[k] << endl;

		string H1;
		for (int i = 0; i < 5; i++) H1.append(dec2hex(w[i], 8)); //输出H1
		cout << "H1=" << H1 << endl;

		u32 BlockKey1_1 = encryptedVerifierHashInputBlockKey[0],
			BlockKey1_2 = encryptedVerifierHashInputBlockKey[1]; //InputBlockKey
		u32 BlockKey2_1 = encryptedVerifierHashValueBlockKey[0],
			BlockKey2_2 = encryptedVerifierHashValueBlockKey[1]; //ValueBlockKey

		u32 w1[16]; //新的SHA1的输入分组
		for (int i = 0; i < 5; i++)
		{
			w1[i] = w[i]; //10万次迭代的输出赋给w1
		}
		w[5] = BlockKey1_1; //拼接64位的Key
		w[6] = BlockKey1_2;
		w[7] = 2147483648; //补1再补0的trick
		w[8] = w[9] = w[10] = w[11] = w[12] = w[13] = w[14] = 0;
		w[15] = 7 * 32; //最后一个32位为明文长度

		sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //一次SHA1

		u32 rKey1[4]; //输出保存在rKey1中，只截取128位
		for (int i = 0; i < 4; i++)
		{
			rKey1[i] = copy_digest[i]; //输出赋给rKey1
		}

		for (int i = 0; i < 5; i++) //H0-H4
		{
			copy_digest[i] = digest[i];
		}

		w1[5] = BlockKey2_1; //原理同上
		w1[6] = BlockKey2_2;
		w1[7] = 2147483648;
		w1[8] = w1[9] = w1[10] = w1[11] = w1[12] = w1[13] = w1[14] = 0;
		w1[15] = 6 * 32;

		sha1_transform(&w1[0], &w1[4], &w1[8], &w1[12], copy_digest);

		u32 rKey2[5];
		for (int i = 0; i < 4; i++)
		{
			rKey2[i] = copy_digest[i]; //截取SHA1的前128位，得到加密用的秘钥rKey2
		}
		for (int i = 0; i < 5; i++) //H0-H4
		{
			copy_digest[i] = digest[i];
		}

		u32 k1[100], k2[100]; //储存加密解密的秘钥扩展
		memset(k1, 0, sizeof(k1)); //都初始化为0
		memset(k2, 0, sizeof(k2));

		AES128_ExpandKey(rKey1, k1, te0, te1, te2, te3, te4); //解密秘钥扩展
		AES128_InvertKey(k1, td0, td1, td2, td3, td4, te0, te1, te2, te3, te4); //解密秘钥反转

		AES128_ExpandKey(rKey2, k2, te0, te1, te2, te3, te4); //加密秘钥扩展

		num = VerifierHashInput.length() / 8; //将verifierHashInput的16进制字符串转换为10进制整数存储
		for (u32 i = 0, j = 0; i < num; j += 4, i++)
		{
			string b(VerifierHashInput.begin() + j, VerifierHashInput.begin() + j + 8); //每8个16进制字符包含32bit
			w[i] = strtoll(b.c_str(), NULL, 16); //16进制字符串转10进制整数
		}

		u32 mVerifier[4]; //对verifierHashInput进行AES解密后的输出
		memset(mVerifier, 0, sizeof(mVerifier)); //初始化为0

		AES128_decrypt(w, mVerifier, k1, td0, td1, td2, td3, td4); //AES解密，输出保存在mVerifier中

		for (int i = 0; i < 4; i++)
		{
			mVerifier[i] ^= salt_1[i]; //解密的输出与salt做异或
		}

		for (int i = 0; i < 4; i++)
		{
			w[i] = mVerifier[i]; //最后一次SHA1的前128位的输入
		}
		w[4] = 2147483648; //补1再补0的trick
		for (int i = 5; i < 15; i++)
		{
			w[i] = 0; //除最后32位其余都置为0
		}
		w[15] = 128; //储存明文长度128

		sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //最后一次SHA1运算

		u32 verifierHash[4]; //储存AES加密的输入
		for (int i = 0; i < 4; i++)
		{
			verifierHash[i] = copy_digest[i]; //截取128位
		}

		for (int i = 0; i < 5; i++)
		{
			copy_digest[i] = digest[i]; //别忘了还原copy_digest的值
		}
		for (int i = 0; i < 4; i++)
		{
			verifierHash[i] ^= salt_1[i]; //第二次亦或操作，亦或之后作为AES加密的输入
		}

		u32 verifier[4]; //储存AES加密的输出，也就是最后的输出
		AES128_encrypt(verifierHash, verifier, k2, te0, te1, te2, te3, te4); //AES128 CBC加密

		string result;
		for (int i = 0; i < 4; i++)
		{
			result.append(dec2hex(verifier[i], 8)); //转换为16进制字符串
		}
		cout << "result=" << result;

		if (!verifierHashValue.compare(0, 32, result)) //如果和提取出的信息相同，则找到了密码，退出
		{
			cout << "Check! pwd=" << pwd << endl;
			break;
		}
	}
	//char* cbuf = (char*)"gtwIzAujRYyy27il7DREHKiUWxx5BjSubwdZB7cthD8=";
	//char *salt = (char*)"YUA=";
	//char* plaintext_out;
	//char* decoded;
	//decoded = decode(salt);
	//printf("decoded: %s\n", decoded);
	////base64_decrypt_text(cbuf, pbuf, s, 45);
	cin.get();
	return 0;
}

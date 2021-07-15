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

void sha1_array(string a, u32* w) //SHA1�������
{
	u32 num = a.length() / 8;
	//cout << "a=" << a << endl;
	for (u32 i = 0, j = 0; i < num; j += 8, i++)
	{
		string b(a.begin() + j, a.begin() + j + 8); //ÿ��ȡ��8λ��ת��Ϊ10��������
		w[i] = strtoll(b.c_str(), NULL, 16);
		//if (i == num - 1) cout << endl << "b=" << b << endl;
	}
	//cout << "w[num]=" << num << " " << w[num-1] << endl;
	u32 c = (512 - num * 32) / 32; //��Ҫ�����ٸ�32bit
	for (u32 i = 0, j = num; i < c; i++, j++)
	{
		if (j == num) w[j] = 2147483648; //�Ȳ�һ��1�ٲ�31��0
		else if (i < c - 1) w[j] = 0; //�������32bit���඼Ϊ0
		else w[j] = a.length() * 4; //���32bitΪ���ĳ���
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
std::string dec2hex(int i, int width) //ʮ����ת��Ϊ16�����ַ���
{
	std::stringstream ioss; //�����ַ�����
	std::string s_temp; //���ת�����ַ�
	ioss << std::hex << i; //��ʮ������ʽ���
	ioss >> s_temp;
	std::string s(width - s_temp.size(), '0'); //��0
	s += s_temp; //�ϲ�
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
//	for (int i = 0; i<4; i++) {//�������������ݱ������ԭindex��������λ���
//		temp |= base64_back[cbuf[i]] << (18 - 6 * i);//temp�ĸ�1byteδʹ��
//	}
//	for (int i = 0; i<3; i++) {//��λ���õ���temp�ĵ���byte�ֱ�Ϊԭ������byte
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
u32 swap32(unsigned int a) //λ��ת����
{
	u32 res = 0; //��ʼ�����Ϊ0
	int b = 1;
	for (int i = 0; i < 32; i++) //�ӵ�λɨ�赽��λ
	{
		b <<= i; //b����iλ����a�������㣬�����Ϊ0��˵��a�ĵ�iλΪ1
		int c = a | b;
		if (c != 0) { //�������a�ĵ�iλ��Ϊ0
			int d = 1;
			d <<= 32 - i;
			res |= d; //res�ĵ�32-iλ��Ϊ1
		}
	}
	return res;
}
int main()
{
	string salt("c97d2b037445a85dcf6b682af7b09bf2"); //��ʼ��salt����ȡ�Ĳ���
	string VerifierHashInput("72f959ec5129204d875d3290ede137ce");
	string verifierHashValue("82dc08cc0ba3458cb2dbb8a5ec34441ca8945b1c790634ae6f075907b72d843f");

	u32 w[16];

	u32 salt_1[4]; //��saltֵת��Ϊʮ���ƴ洢�������Ժ��������
	for (int i = 0; i < 4; i++)
	{
		salt_1[i] = w[i];
	}

	u32 digest[5] = { sha1_constants_t{ SHA1M_A }, sha1_constants_t{ SHA1M_B }, //��ʼ��SHA1������������H0-H4
		sha1_constants_t{ SHA1M_C }, sha1_constants_t{ SHA1M_D }, sha1_constants_t{ SHA1M_E } };

	u32 copy_digest[5]; //����һ��H0-H4��ֵ�������Ժ���
	for (int i = 0; i < 5; i++)
	{
		copy_digest[i] = digest[i];
	}

	for (u32 pwd = 0; pwd <= 999; pwd++) //�������е��������
	{

		string password;
		string salt_pwd(salt);
		password.append(dec2hex(pwd, 3));
		salt_pwd.append(password);
		salt_pwd.append("f0000"); //salt+pwdԤ������������salt_pwd��
		//cout << salt_pwd;

		sha1_array(salt_pwd, w); //��һ����SHA1������飬�ֳ�16��32bit��u32����
		//for (int k = 0; k < 16; k++) cout << "w=" << w[k] << endl;


		sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //��һ��SHA1���㣬���������copy_digest��
		//for (int k = 0; k < 5; k++) cout << "digest=" << copy_digest[k] << endl;

		//w[0] = 0; //����10��ε�����������飬��һ�ֵ���������Ϊ0
		//for (u32 i = 1; i <= 5; i++) //��һ����SHA1�����Ϊ10��ε���������
		//{
		//	w[i] = copy_digest[i];
		//}
		//for (u32 i = 0, j = 6; i < 10; i++, j++) //SHA1�������
		//{
		//	if (j == 6) w[j] = 2147483648; //�Ȳ�1�ٲ�0����˴���1�����31��0������
		//	else if (i < 10) w[j] = 0; //����ĩβ��32λ���඼��0
		//	else w[j] = 192; //ĩβ��32λ�������ĳ���192
		//}

		u32 counter = 0; //������
		u32 num = (512 - 192) / 32; //���㣬��Ϊ������192bit����Ҫ��10��32bit

		for (int iter = 0; iter < 100000; iter++) //10��ε���
		{
			w[0] = swap32(counter); //λ��ת����Ϊ��һ������������32λ
			for (u32 i = 1; i <= 5; i++) //�����Ϊ���룬���������copy_digest��
			{
				w[i] = copy_digest[i - 1]; //w��1-5��Ϊ��һ��SHA1�����������counter+��һ�����������
			}
			for (u32 i = 0, j = 192 / 32; i < num; i++, j++) //����������λ
			{
				if (j == 6) w[j] = 2147483648; //1�����31��0������
				else if (i < num - 1) w[j] = 0; //�������һ��32λ���඼��0
				else w[j] = 192; //���32����ֵΪ���ĳ���192
			}

			for (int i = 0; i < 5; i++)
			{
				copy_digest[i] = digest[i]; //SHA1������H0-H4
			}
			counter++; //��������һ

			sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //SHA1����
		}

		for (u32 i = 0; i < 5; i++)
		{
			w[i] = w[i + 1]; //���һ�ε���ʱҲ���˷��飬���ʵ�������w��1-5������Ϊ0-4
		}
		//for (int k = 0; k < 16; k++) cout << "final w=" << w[k] << endl;

		string H1;
		for (int i = 0; i < 5; i++) H1.append(dec2hex(w[i], 8)); //���H1
		cout << "H1=" << H1 << endl;

		u32 BlockKey1_1 = encryptedVerifierHashInputBlockKey[0],
			BlockKey1_2 = encryptedVerifierHashInputBlockKey[1]; //InputBlockKey
		u32 BlockKey2_1 = encryptedVerifierHashValueBlockKey[0],
			BlockKey2_2 = encryptedVerifierHashValueBlockKey[1]; //ValueBlockKey

		u32 w1[16]; //�µ�SHA1���������
		for (int i = 0; i < 5; i++)
		{
			w1[i] = w[i]; //10��ε������������w1
		}
		w[5] = BlockKey1_1; //ƴ��64λ��Key
		w[6] = BlockKey1_2;
		w[7] = 2147483648; //��1�ٲ�0��trick
		w[8] = w[9] = w[10] = w[11] = w[12] = w[13] = w[14] = 0;
		w[15] = 7 * 32; //���һ��32λΪ���ĳ���

		sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //һ��SHA1

		u32 rKey1[4]; //���������rKey1�У�ֻ��ȡ128λ
		for (int i = 0; i < 4; i++)
		{
			rKey1[i] = copy_digest[i]; //�������rKey1
		}

		for (int i = 0; i < 5; i++) //H0-H4
		{
			copy_digest[i] = digest[i];
		}

		w1[5] = BlockKey2_1; //ԭ��ͬ��
		w1[6] = BlockKey2_2;
		w1[7] = 2147483648;
		w1[8] = w1[9] = w1[10] = w1[11] = w1[12] = w1[13] = w1[14] = 0;
		w1[15] = 6 * 32;

		sha1_transform(&w1[0], &w1[4], &w1[8], &w1[12], copy_digest);

		u32 rKey2[5];
		for (int i = 0; i < 4; i++)
		{
			rKey2[i] = copy_digest[i]; //��ȡSHA1��ǰ128λ���õ������õ���ԿrKey2
		}
		for (int i = 0; i < 5; i++) //H0-H4
		{
			copy_digest[i] = digest[i];
		}

		u32 k1[100], k2[100]; //������ܽ��ܵ���Կ��չ
		memset(k1, 0, sizeof(k1)); //����ʼ��Ϊ0
		memset(k2, 0, sizeof(k2));

		AES128_ExpandKey(rKey1, k1, te0, te1, te2, te3, te4); //������Կ��չ
		AES128_InvertKey(k1, td0, td1, td2, td3, td4, te0, te1, te2, te3, te4); //������Կ��ת

		AES128_ExpandKey(rKey2, k2, te0, te1, te2, te3, te4); //������Կ��չ

		num = VerifierHashInput.length() / 8; //��verifierHashInput��16�����ַ���ת��Ϊ10���������洢
		for (u32 i = 0, j = 0; i < num; j += 4, i++)
		{
			string b(VerifierHashInput.begin() + j, VerifierHashInput.begin() + j + 8); //ÿ8��16�����ַ�����32bit
			w[i] = strtoll(b.c_str(), NULL, 16); //16�����ַ���ת10��������
		}

		u32 mVerifier[4]; //��verifierHashInput����AES���ܺ�����
		memset(mVerifier, 0, sizeof(mVerifier)); //��ʼ��Ϊ0

		AES128_decrypt(w, mVerifier, k1, td0, td1, td2, td3, td4); //AES���ܣ����������mVerifier��

		for (int i = 0; i < 4; i++)
		{
			mVerifier[i] ^= salt_1[i]; //���ܵ������salt�����
		}

		for (int i = 0; i < 4; i++)
		{
			w[i] = mVerifier[i]; //���һ��SHA1��ǰ128λ������
		}
		w[4] = 2147483648; //��1�ٲ�0��trick
		for (int i = 5; i < 15; i++)
		{
			w[i] = 0; //�����32λ���඼��Ϊ0
		}
		w[15] = 128; //�������ĳ���128

		sha1_transform(&w[0], &w[4], &w[8], &w[12], copy_digest); //���һ��SHA1����

		u32 verifierHash[4]; //����AES���ܵ�����
		for (int i = 0; i < 4; i++)
		{
			verifierHash[i] = copy_digest[i]; //��ȡ128λ
		}

		for (int i = 0; i < 5; i++)
		{
			copy_digest[i] = digest[i]; //�����˻�ԭcopy_digest��ֵ
		}
		for (int i = 0; i < 4; i++)
		{
			verifierHash[i] ^= salt_1[i]; //�ڶ��������������֮����ΪAES���ܵ�����
		}

		u32 verifier[4]; //����AES���ܵ������Ҳ�����������
		AES128_encrypt(verifierHash, verifier, k2, te0, te1, te2, te3, te4); //AES128 CBC����

		string result;
		for (int i = 0; i < 4; i++)
		{
			result.append(dec2hex(verifier[i], 8)); //ת��Ϊ16�����ַ���
		}
		cout << "result=" << result;

		if (!verifierHashValue.compare(0, 32, result)) //�������ȡ������Ϣ��ͬ�����ҵ������룬�˳�
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
/*
 * main.c
 *
 *  Created on: 2018年2月20日
 *      Author: 死神柯南
 */


#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#define N 100000

clock_t start, stop;
double duration;
double f(int n, double a[], double x)
{
	int i;
	double p = a[0];
	for(i = 1; i <= n; i++)
	{
		p += a[i] * pow(x, i);
	}
	return p;
}

double f1(int n, double a[], double x)
{
	int i;
	double p = a[n];
	for(i = n; i > 0; i--)
	{
		p = a[i-1] +x*p;
	}
	return p;
}

int main(int argc, char* argv[])
{
	int i;
	double a[N];
	for(i = 0; i < N; i++)
	{
		a[i] = i + 3;
	}
	start = clock();
	f(9, a, 2);
	stop = clock();
	duration = ((double) (stop - start) / CLK_TCK);
	printf("%6.2e, %6.2e\n", duration, (double)(stop - start)/duration);

	return 0;

}

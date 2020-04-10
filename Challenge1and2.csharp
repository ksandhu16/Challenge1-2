using System;
using System.Collections.Generic;

public class CorporateInfo
{
public string _bond;
public string _type;
public double _term;
public double _yield;
}

public class Point
{
public double x, y;
public Point(double x, double y)
{
this.x = x;
this.y = y;
}

public static void displayPoint(Point p)
{
Console.WriteLine("(" + p.x + ", " + p.y + ")");
}
}

public class CalculateClass
{
public List<CorporateInfo> GetData()
{
List<CorporateInfo> CInfoList = new List<CorporateInfo>();
//Sample Data
CInfoList.Add(new CorporateInfo{_bond = "C1", _type = "Corporate", _term = 10.3, _yield = 5.30});
CInfoList.Add(new CorporateInfo{_bond = "C2", _type = "Corporate", _term = 15.2, _yield = 8.30});
CInfoList.Add(new CorporateInfo{_bond = "G1", _type = "Government", _term = 9.4, _yield = 3.70});
CInfoList.Add(new CorporateInfo{_bond = "G2", _type = "Government", _term = 12, _yield = 4.80});
CInfoList.Add(new CorporateInfo{_bond = "G3", _type = "Government", _term = 16.3, _yield = 5.5});
return CInfoList;
}

public void GetSpread_to_Benchmark(List<CorporateInfo> CInfoList)
{
List<CorporateInfo> CorpList = new List<CorporateInfo>();
foreach (CorporateInfo Obj in CInfoList)
{
if (Obj._type == "Corporate")
{
CorpList.Add(Obj);
}
}

Console.WriteLine();
Console.WriteLine("bond, Benchmark , Spread_to_Benchmark");
foreach (CorporateInfo CopObj in CorpList)
{
string maxName = "";
double MaxValue = 0;
foreach (CorporateInfo Obj in CInfoList)
{
if (Obj._type == "Government")
{
double Tempvalue = 0;
Tempvalue = CopObj._yield - Obj._yield;
if (Tempvalue > MaxValue)
{
MaxValue = Tempvalue;
maxName = Obj._bond;
}
}
}

Console.WriteLine(CopObj._bond + " ,  " + maxName + " ,  " + MaxValue);
}
}

public void GetSpread_to_curve(List<CorporateInfo> CInfoList)
{
//CorporateInfo C1Obj = new CorporateInfo();
List<CorporateInfo> CorpList = new List<CorporateInfo>();
foreach (CorporateInfo Obj in CInfoList)
{
if (Obj._type == "Corporate")
{
CorpList.Add(Obj);
}
}

foreach (CorporateInfo CopObj in CorpList)
{
Point A = new Point(CopObj._term, CopObj._yield);
Point B = new Point(CopObj._term, 0);
Point C = new Point(0, 0);
Point D = new Point(0, 0);
bool foundC = false;
bool foundD = false;
foreach (CorporateInfo Obj in CInfoList)
{
if (Obj._type == "Government")
{
if (Obj._term < CopObj._term)
{
foundC = true;
C.x = Obj._term;
C.y = Obj._yield;
}

if (Obj._term > CopObj._term)
{
foundD = true;
D.x = Obj._term;
D.y = Obj._yield;
}

if (foundC == true && foundD == true)
{
lineLineIntersection(A, B, C, D, CopObj._bond);
break;
}
}
}
}
}

// Point
public void lineLineIntersection(Point A, Point B, Point C, Point D, string Bname)
{

Point intersection;

double a1 = B.y - A.y;
double b1 = A.x - B.x;
double c1 = a1 * (A.x) + b1 * (A.y);

double a2 = D.y - C.y;
double b2 = C.x - D.x;
double c2 = a2 * (C.x) + b2 * (C.y);
double determinant = a1 * b2 - a2 * b1;
if (determinant == 0)
{
intersection = new Point(double.MaxValue, double.MaxValue);
}
else
{
double x = (b2 * c1 - b1 * c2) / determinant;
double y = (a1 * c2 - a2 * c1) / determinant;
intersection = new Point(x, y);
}

if (intersection.x == double.MaxValue && intersection.y == double.MaxValue)
{
Console.WriteLine("Cannot find spread_to_curve");
}
else
{
// Math.Round(dx2,2)
double Differnce = (A.y - intersection.y);
Console.WriteLine();
Console.WriteLine("bond,spread_to_curve ");
Console.WriteLine(Bname + " , " + Math.Round(Differnce, 2));


}
}
}

public class Program
{
public static void Main()
{
List<CorporateInfo> CInfoList = new List<CorporateInfo>();
CalculateClass Cobj = new CalculateClass();
CInfoList = Cobj.GetData();
Cobj.GetSpread_to_Benchmark(CInfoList);
Cobj.GetSpread_to_curve(CInfoList);
}
}

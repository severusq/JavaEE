/*
 * Employee.cpp
 *
 *  Created on: 2017年9月12日
 *      Author: 死神柯南
 */
#include <iostream>
#include <string>
#include <cstring>
using namespace std;

class Employee {
public:
	Employee(const std::string& name, const std::string& ssn);
	const std::string &get_name() const;
	void print(std::ostream &out) const;
	void print(std::ostream &out, const std::string &msg) const;
protected:
	std::string m_name;
	std::string m_ssn;
};

class Manager : public Employee {
public:
	Manager(const std::string& name, const std::string& ssn, const std::string& title);
	const std::string title_name() const;
	const std::string& get_title() const;
	void print(std::ostream& out) const;
private:
	std::string m_title;
};

Employee::Employee(const std::string& name, const std::string& ssn):
	m_name(name), m_ssn(ssn)
{

}
inline const std::string& Employee::get_name() const
{
	return m_name;
}

inline void Employee::print(std::ostream& out) const
{
	out << m_name << std::endl;
	out << m_ssn << std::endl;
}

inline void Employee::print(std::ostream& out, const std::string& msg) const
{
	out << msg << std::endl;
	print(out);
}

Manager::Manager(const string& name, const string& ssn, const string& title = "") :
	Employee(name, ssn), m_title(title)
{

}
inline void Manager::print(std::ostream& out) const
{
	Employee::print(out);
	out << m_title << std::endl;
}

inline const std::string& Manager::get_title() const
{
	return m_title;
}

inline const std::string Manager::title_name() const
{
	return std::string(m_title+": "+m_name);
}

int main()
{
	Employee bob("Bob Jones", "555-44-0000");
	Manager bill("Bill Smith", "666-55-1234", "Important Person");

	std::string name = bill.get_name();
	std::cout << bill.title_name() << '\n' << std::endl;
	bill.print(cout);
	bob.print(cout);
	bob.print(cout, "Employee:");
	return 0;
}

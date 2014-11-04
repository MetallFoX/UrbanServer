package com.urban.data.jdbc.stub;

import com.urban.data.ContactType;

import java.util.*;

public class OrganizationStubGenOracle {
    private static ArrayList<OrganizationStub> orgs = new ArrayList<OrganizationStub>();
    private static ArrayList<CategoryStub> categories = new ArrayList<CategoryStub>();

    private static HashMap<OrganizationStub, Integer> orgMap = new HashMap<OrganizationStub, Integer>();

    public static void main(String args[]) {
        fillOrganizationData();

        System.out.printf(
                "insert into contacttype (id, name) "
                + "values (1, 'PHONE');%n");
        System.out.printf(
                "insert into contacttype (id, name) "
                + "values (2, 'EMAIL');%n");
        System.out.printf(
                "insert into contacttype (id, name) "
                + "values (3, 'WEB');%n");
        System.out.printf(
                "insert into contacttype (id, name) "
                + "values (4, 'SKYPE');%n%n");

        int i = 0;
        int j = 0;
        for (OrganizationStub org : orgs) {
            System.out.printf(
                    "insert into organization (id, logo, name, description) "
                    + "values (%d, null, '%s', '%s');%n", i, org.name, org.desc);
            orgMap.put(org, i);

            System.out.printf(
                    "insert into place (id, lat, alt, description) "
                    + "values (%d, %s, %s, '%s');%n", i, org.place.lat, org.place.alt, "");

            System.out.printf(
                    "insert into organization_place (organization, place) "
                    + "values (%d, %d);%n", i, i);

            System.out.printf(
                    "insert into address (id, street, house, letter, floor, flat, place) "
                    + "values (%d, '%s', %d, '%s', %d, %d, %d);%n", i, org.place.address.street, org.place.address.house, org.place.address.letter, org.place.address.floor, org.place.address.flat, i);

            /*System.out.printf(
                    "insert into place_address (place, address) "
                    + "values (%d, %d);%n", i, i);*/

            Iterator<ContactStub> iterator = org.contacts.iterator();
            while (iterator.hasNext()) {
                ContactStub contract = (ContactStub)iterator.next();
                System.out.printf(
                        "insert into contact (id, contact, contacttype) "
                        + "values (%d, '%s', %d);%n", j, contract.info, contract.type.ordinal()+1);

                System.out.printf(
                        "insert into organization_contact (organization, contact) "
                        + "values (%d, %d);%n", i, j);

                j++;
            }

            System.out.println();

            i++;
        }

        int positionId = 0;
        int categoryId = 0;
        for (CategoryStub category : categories) {
            Iterator<PositionStub> positionIterator = category.positions.iterator();

            System.out.printf(
                    "insert into category (id, name, parent, \"order\") "
                    + "values (%d, '%s', null, %d);%n", categoryId, category.name, categoryId);

            while (positionIterator.hasNext()) {
                PositionStub position = (PositionStub)positionIterator.next();
                System.out.printf(
                        "insert into position (id, name, organization) "
                        + "values (%d, '%s', %d);%n", positionId, position.name, orgMap.get(position.organization));

                System.out.printf(
                        "insert into category_position (position, category) "
                        + "values (%d, %d);%n", positionId, categoryId);

                positionId++;
            }
            categoryId++;
        }

        System.out.println();

    }

    private static void fillOrganizationData() {


        CategoryStub categoryFood = new CategoryStub("���", 0);
        categories.add(categoryFood);
        CategoryStub categorySport = new CategoryStub("�����", 1);
        categories.add(categorySport);
        CategoryStub categoryDrink = new CategoryStub("����", 2);
        categories.add(categoryDrink);

        AddressStub address = new AddressStub("�����������", 107, ' ', 1, 0);
        PlaceStub place = new PlaceStub(39.888486, 59.20806, address);
        OrganizationStub organization = new OrganizationStub("Green Cafe", "������-���� � Green Cafe. ����� �������� ������ �������� ��� - ��� ������-���� � Green Cafe. ������������� � ������� ����, �������� ������ � ����������� ����.", place);
        organization.addContact(ContactType.Type.EMAIL, "Green@wologda.ru");
        organization.addContact(ContactType.Type.PHONE, "750675");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�������������", 149, ' ', 1, 0);
        place = new PlaceStub(39.895188, 59.249726, address);
        organization = new OrganizationStub("������� ����", "���� �������� - �������� ����� ��� ����, ����� ���������� � �������� ������������� ��� ������ ��������� �������. ������������ �������� ������ � ����� �������.", place);
        organization.addContact(ContactType.Type.PHONE, "+7(8172)");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�������", 56, ' ', 1, 0);
        place = new PlaceStub(39.897272, 59.209769, address);
        organization = new OrganizationStub("���������� ���� � ���� ����������", "���������� �� ��������� �� ��������� � 21:00 (������ �� ������� � ��������� �������), ����� ������ � 15:00-18:00 �� ����� �� �������. ����� �����������: ����� �������� ����� ������� ���������� ����� �������� ����� �������������� � ������� ������� � �������.", place);
        organization.addContact(ContactType.Type.PHONE, "562671");
        organization.addContact(ContactType.Type.PHONE, "562277");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);
        categorySport.addByOrganization(organization);

        address = new AddressStub("���������", 11, ' ', 1, 0);
        place = new PlaceStub(39.883779, 59.2197, address);
        organization = new OrganizationStub("������ ����", "������������ ��������, ���� ���������� �������� ������� ������ ���� �������. ����-�������� � � ������, ���� �������.", place);
        organization.addContact(ContactType.Type.PHONE, "210321");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����������", 15, ' ', 1, 0);
        place = new PlaceStub(39.893032, 59.221422, address);
        organization = new OrganizationStub("��������� ���� �����", " �� �������� �������������. ��� ��� �������, �����������, �����������, �������� �����", place);
        organization.addContact(ContactType.Type.EMAIL, "info@aveny.ru");
        organization.addContact(ContactType.Type.PHONE, "503573");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("������", 6, ' ', 1, 0);
        place = new PlaceStub(39.887247, 59.223945, address);
        organization = new OrganizationStub("���� \"�����\"", "����� ������ ������� �����, ������� ������� � ����� ���������� ����!", place);
        organization.addContact(ContactType.Type.EMAIL, "mail@example.com");
        organization.addContact(ContactType.Type.PHONE, "212141");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�������� ������", 8, ' ', 1, 0);
        place = new PlaceStub(39.887947, 59.221781, address);
        organization = new OrganizationStub("���� \"���������\"", "���� \"���������\" - ������ ����� ��� ������ ���������: ���������� ���� �������������� ����������, ��������� ���� ��� ������ ��������� � ��������� ����������. � ����� ������ ������� �� ������� ����� ������ ������.", place);
        organization.addContact(ContactType.Type.EMAIL, "PManager@kluchik-vologda.ru");
        organization.addContact(ContactType.Type.PHONE, "720456");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("������", 51, ' ', 1, 0);
        place = new PlaceStub(39.890508, 59.209, address);
        organization = new OrganizationStub("���� �����", "��������� ���� ����� ����� �������. ���-��: 60 ���� ������� ���� ��� ����������� ��������: 350�. ������ ����� � 12-00 �� 14-00", place);
        organization.addContact(ContactType.Type.PHONE, "758956");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����", 9, ' ', 1, 0);
        place = new PlaceStub(39.889852, 59.220879, address);
        organization = new OrganizationStub("���� �������� ����", "����� ��� ��������� ������������ �������� ��������� ����������� ������� 30-�, ����� �� �������� � ��������, ����� �������� ��������� � ���� ������ ������� ���� �, ����������� ��� ����������� �������, ������� �������� ����� ������������ ������.", place);
        organization.addContact(ContactType.Type.PHONE, "723542");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("���������� 6 �����", 143, ' ', 1, 0);
        place = new PlaceStub(39.90144, 59.223683, address);
        organization = new OrganizationStub("���� ������� ����", "� ��������� ����� ������� ��������� ���� �������� ����. ��� �������� ������������� ��������: - ���������� ��������, ���������� ����� ������ � ����������� ����� ���-��.", place);
        organization.addContact(ContactType.Type.EMAIL, "redbridge@yandex.ru");
        organization.addContact(ContactType.Type.PHONE, "547930");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����������", 4, ' ', 1, 0);
        place = new PlaceStub(39.892223, 59.221528, address);
        organization = new OrganizationStub("���� ���������", "160 ���������� ����, ����� �������, ����������, ����������", place);
        organization.addContact(ContactType.Type.PHONE, "769655");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("��������������", 44, ' ', 1, 0);
        place = new PlaceStub(39.877419, 59.221781, address);
        organization = new OrganizationStub("���� \"����������\"", "", place);
        organization.addContact(ContactType.Type.PHONE, "757437");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����", 17, '�', 1, 0);
        place = new PlaceStub(39.886609, 59.219078, address);
        organization = new OrganizationStub("���� \"���\"", "���������� ��� �������� ���� ������ ������ ����, ��� ��� ����������� � ��������� � ��������������� ������! �� ������������, ���� ������ �� ��� ����� ��� ���� ��, ��� �� ����! ������������ �����: ��������, �����������, �����������, ���������.", place);
        organization.addContact(ContactType.Type.PHONE, "563884");
        organization.addContact(ContactType.Type.PHONE, "505026");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����", 8, ' ', 1, 0);
        place = new PlaceStub(39.889654, 59.221763, address);
        organization = new OrganizationStub("���� \"��� ���\"", "���������� ������, ������� �������� ���������� ������ ���������, ����������� � ���������� ���������� � ��� ��� ������� �������������� ��������� ���������� � ���������� ��������� ������.", place);
        organization.addContact(ContactType.Type.EMAIL, "hotel@spasskaya.ru");
        organization.addContact(ContactType.Type.PHONE, "787349");
        organization.addContact(ContactType.Type.PHONE, "787841");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("������", 4, '�', 1, 0);
        place = new PlaceStub(39.888819, 59.223554, address);
        organization = new OrganizationStub("������ ��� ����", "\"����\" �������� ����� �� ������ ������ ����� ������ ������. ����������� � ����� �������������� ������������ �����, �� ��������� ��� �� ������� ���������� � �������� �������, ����� ��� � ��������� �����. ������ ������� ������� ���� �������� � ����� ��� ������.", place);
        organization.addContact(ContactType.Type.PHONE, "265590");
        orgs.add(organization);
        categoryDrink.addByOrganization(organization);

        address = new AddressStub("����������� �����", 22, ' ', 1, 0);
        place = new PlaceStub(39.859246, 59.197233, address);
        organization = new OrganizationStub("����.com", "�������� ������� ���� ������, ��� �������� ������� � �������� �������. ��� ������ ������ ������� �������� �� ����, � ���������� ������� ����� ��������.", place);
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�������", 20, ' ', 1, 0);
        place = new PlaceStub(39.890651, 59.213528, address);
        organization = new OrganizationStub("������� \"������� ������\"", "������ �������� � ������ \"�������\", ��� ����� ����������� ��������� ������� ��������, ������� ���������� ������ ����, ���, ��������� � ����������! � ��������, ��������� ����� ��� ������� ��������� � ������� �������� ��������.", place);
        organization.addContact(ContactType.Type.EMAIL, "mkulkova@kluchik-vologda.ru");
        organization.addContact(ContactType.Type.PHONE, "752768");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�����������", 38, ' ', 1, 0);
        place = new PlaceStub(39.875811, 59.220662, address);
        organization = new OrganizationStub("�������-�������� ��������", "������ ������ ��������� � �������� ����, ������� ���������������� ����, �������� �� ���� � ����!", place);
        organization.addContact(ContactType.Type.PHONE, "501361");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����������", 33, ' ', 1, 0);
        place = new PlaceStub(39.893715, 59.215499, address);
        organization = new OrganizationStub("�������� \"��� �����\"", "��������� ����������� �����.", place);
        organization.addContact(ContactType.Type.PHONE, "721066");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����������", 43, ' ', 1, 0);
        place = new PlaceStub(39.885845, 59.215099, address);
        organization = new OrganizationStub("����� ���� \"������\"", "����� ���� \"������\". ���������� ���������� �����������.", place);
        organization.addContact(ContactType.Type.PHONE, "721450");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����", 82, ' ', 1, 0);
        place = new PlaceStub(39.880204, 59.211617, address);
        organization = new OrganizationStub("����", "�������������� ����� ��� ��������� (� �������������� ��������� ����), ������� ���������, ������� ��� � ������� ��������.", place);
        organization.addContact(ContactType.Type.PHONE, "570410");
        orgs.add(organization);
        categoryDrink.addByOrganization(organization);

        address = new AddressStub("�����������", 38, ' ', 1, 0);
        place = new PlaceStub(39.875811, 59.220662, address);
        organization = new OrganizationStub("��� ����", "74 ���������� �����, ������ ���� �� 12 ��������, ������� � ����������� �����", place);
        organization.addContact(ContactType.Type.PHONE, "720575");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����������", 22, ' ', 1, 0);
        place = new PlaceStub(39.843678, 59.237255, address);
        organization = new OrganizationStub("PARADISE CLUB", "��� �� ������� ���������� � �� �� �������!� Party Club X.O.������ ���� ����� � ���������� ������������� � ���������� ������� ������, ������ �������� ������ �� ����������� ����� �������. �� ��� ����� PARTY CLUB X.O. ��������� � ��������� ������� ����� �������.", place);
        organization.addContact(ContactType.Type.EMAIL, "davologda@rambler.ru");
        organization.addContact(ContactType.Type.PHONE, "783737");
        orgs.add(organization);
        categoryDrink.addByOrganization(organization);

        address = new AddressStub("�������� ������", 61, ' ', 1, 0);
        place = new PlaceStub(39.873547, 59.224033, address);
        organization = new OrganizationStub("��������", "����� ��� ��� ����� ������������ � ������� ������ � �������� ���������� ������������ �����, ���������� �����.", place);
        organization.addContact(ContactType.Type.PHONE, "720771");
        organization.addContact(ContactType.Type.PHONE, "89115339260");
        organization.addContact(ContactType.Type.PHONE, "89115288808");
        orgs.add(organization);
        categoryDrink.addByOrganization(organization);

        address = new AddressStub("���������", 19, ' ', 1, 0);
        place = new PlaceStub(39.891011, 59.211782, address);
        organization = new OrganizationStub("�����-�����", "������������� ����� ��� ������� ������ � �����. ��� ��� ����� �������, ����������� � ��������� �����.", place);
        organization.addContact(ContactType.Type.EMAIL, "752757");
        organization.addContact(ContactType.Type.PHONE, "info@hurdy-gurdyclub.ru");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("��������", 26, ' ', 1, 0);
        place = new PlaceStub(39.925605, 59.211073, address);
        organization = new OrganizationStub("IRRIS", "���-���.", place);
        organization.addContact(ContactType.Type.PHONE, "+79115032350");
        orgs.add(organization);


        address = new AddressStub("�������� ������", 10, ' ', 2, 0);
        place = new PlaceStub(39.887687, 59.221836, address);
        organization = new OrganizationStub("����-�������� �������", "�������� ��������������� ����-�������� ������� � ���� �� �������� ���� ������ �������, ��� ����� �� �������� ������ ��������� � ���������� � �������� � �������� ����������, �� � ������� �������� ����� � �������� ������� ����������� ������������, ��������� � ��������� ����������� ������������ �����.", place);
        organization.addContact(ContactType.Type.EMAIL, "");
        organization.addContact(ContactType.Type.PHONE, "");
        orgs.add(organization);
        categoryDrink.addByOrganization(organization);

        address = new AddressStub("�����������", 25, ' ', 1, 0);
        place = new PlaceStub(39.872371, 59.219709, address);
        organization = new OrganizationStub("���", "������ ���� \"���\" ������ � ������ ����������-���������������� ��������� \"��������\" � ���������� � ������ ������������ ����� �������.", place);
        organization.addContact(ContactType.Type.PHONE, "795056");
        orgs.add(organization);
        categoryDrink.addByOrganization(organization);

        address = new AddressStub("�������������", 2, '�', 1, 0);
        place = new PlaceStub(39.92397, 59.209493, address);
        organization = new OrganizationStub("���� ������", "����������� �� \"���� ������\" ������� � 2005 ����, ��������, �������, ������ ������ ������� � ����� ����� 80-�. � ������ ������ ������ ��������� � �� ��� ���� ������ ��������� ���������� ����� ���� 80-� � 2000-� �����.", place);
        organization.addContact(ContactType.Type.PHONE, "76 79 18");
        organization.addContact(ContactType.Type.PHONE, "76 78 24");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("��������� ��������", 45, ' ', 1, 0);
        place = new PlaceStub(39.904917, 59.212114, address);
        organization = new OrganizationStub("��������", "������� ����� � ������ ����; ��� ���� ��� ������ �������� �� 250 ���� ���, �������� �� 100 ���� � �������-��� �� 50 ���� \"�����\" ������, ������������� ��������� � ��������, ��-���� � ���������, �������� ��� ������� ������", place);
        organization.addContact(ContactType.Type.PHONE, "767346");
        organization.addContact(ContactType.Type.PHONE, "767178");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�������������", 85, ' ', 3, 0);
        place = new PlaceStub(39.843894, 59.207729, address);
        organization = new OrganizationStub("������� ����", "����� ������� ���������� ������������� �������� ����� Brunswick ������ � ������������ ����������� �������� ���������� ����� ������ ��������� ������, ��� ��� �����������, ��� � ��� ��������� ���� ����.", place);
        organization.addContact(ContactType.Type.EMAIL, "bowling@bowlingkluch.ru");
        organization.addContact(ContactType.Type.PHONE, "537848");
        orgs.add(organization);
        categorySport.addByOrganization(organization);

        address = new AddressStub("������", 27, ' ', 1, 0);
        place = new PlaceStub(39.884875, 59.212529, address);
        organization = new OrganizationStub("���������, ������ ����", "���� ������ ���������� - ��� �������, ����� ������ � ���������� �����������! ��� ������ ����������� ���� � ��������, ������� ����� ����� � ��������� ������� ����������, ����� ����� ���������������� ������������ �, ������� ��, ��������������� �����������: �� ���������� �� ������������.", place);
        organization.addContact(ContactType.Type.EMAIL, "fitnessplastilin@mail.ru");
        organization.addContact(ContactType.Type.PHONE, "78 77 78");
        organization.addContact(ContactType.Type.PHONE, "71 44 11");
        orgs.add(organization);
        categorySport.addByOrganization(organization);

        address = new AddressStub("�����������", 7, ' ', 1, 0);
        place = new PlaceStub(39.849239, 59.206618, address);
        organization = new OrganizationStub("���� ����� ������.", "��������� �������� ����� ������ � ������� �� 10 ���, � ��� �� �������� � ������ �����.", place);
        organization.addContact(ContactType.Type.PHONE, "539159");
        orgs.add(organization);
        categorySport.addByOrganization(organization);

        address = new AddressStub("������", 10, ' ', 1, 0);
        place = new PlaceStub(39.8472, 59.215702, address);
        organization = new OrganizationStub("������ ���� ������", "������ - ������ ����, �������� ����������� ����� ������ � ��������� ������� � ���� � �������. ������� ����� ������� - ������� ���������� ������ ������������-��������������� �����.", place);
        organization.addContact(ContactType.Type.EMAIL, "club-parnas@mail.ru");
        organization.addContact(ContactType.Type.PHONE, "52 22 52");
        orgs.add(organization);
        categorySport.addByOrganization(organization);

        address = new AddressStub("�������������", 57, '�', 1, 0);
        place = new PlaceStub(39.88925, 59.213335, address);
        organization = new OrganizationStub("������� ������", " ������� �� 30 ������, ������� �� 1.0 �� 12.2 �. ����������������� ������ - 45 �������.", place);
        organization.addContact(ContactType.Type.PHONE, "720553");
        orgs.add(organization);
        categorySport.addByOrganization(organization);

        address = new AddressStub("����������� �������", 10, ' ', 1, 0);
        place = new PlaceStub(39.884794, 59.223425, address);
        organization = new OrganizationStub("����������� ��������� ��������� �������", "����������� ��������� ��������� ������� ���� ������������ � 1952 ���� �� ���� ��������������� ������ ������������ ���������� �������������� �����.", place);
        organization.addContact(ContactType.Type.EMAIL, "vologda-gallery@yandex.ru");
        organization.addContact(ContactType.Type.PHONE, "721433");
        organization.addContact(ContactType.Type.PHONE, "721228");
        orgs.add(organization);

        address = new AddressStub("�����������", 25, ' ', 1, 0);
        place = new PlaceStub(39.872371, 59.219709, address);
        organization = new OrganizationStub("��������� \"��������\"", "��������� \"��������\" ���������� � 1990 ����. � ����������� ������� ��� �������� ���������� ������� � ����� ������������. ����� �� �������� ����� ����������� ������� �������� �������� ��������� ����� ������������ ������: ���������� ������������ ����������, ������� � ���������� ������.", place);
        organization.addContact(ContactType.Type.EMAIL, "info@spasskaya.ru");
        organization.addContact(ContactType.Type.PHONE, "720145");
        organization.addContact(ContactType.Type.PHONE, "723069");
        orgs.add(organization);

        address = new AddressStub("��������� ��������", 6, ' ', 1, 0);
        place = new PlaceStub(39.893095, 59.218148, address);
        organization = new OrganizationStub("��������� \"������� �����\"", "��������� \"������� �����\" ����������� � ������ ������ ������� �� ��������� ���������, ����� � �������������� ������ �������, ��. ���������, ��. ����������� � ����������� ������. �������� ���� 30 ����, � ��������� ������� ����, ��������, ��������������.", place);
        organization.addContact(ContactType.Type.PHONE, "726241");
        orgs.add(organization);

        address = new AddressStub("�������", 27, ' ', 1, 0);
        place = new PlaceStub(39.889996, 59.215117, address);
        organization = new OrganizationStub("��������� �������", "��������� ������� - ����������� , ��������������� ����� ����� �������, ����������� � ����� 2008 ����. ������ ������������� ��������� ���������� �� ���������� ������������� ����������� ������� � ����� �������� ������� �.�������.", place);
        organization.addContact(ContactType.Type.EMAIL, "hotel@atriumvologda.ru");
        organization.addContact(ContactType.Type.PHONE, "787825");
        orgs.add(organization);

        address = new AddressStub("����", 92, ' ', 1, 0);
        place = new PlaceStub(39.880743, 59.210276, address);
        organization = new OrganizationStub("��������� ��������", "�������� ����� �� ������� � ������ �������. ������������ ��������� ����� ������. ��� ��������� � �����������, ������������ ����� ���������� ������ � � �� �� ����� � 200 ������ �� ����- � ���������������� ��������. ���������� � ��������� ���������� ����������.", place);
        organization.addContact(ContactType.Type.PHONE, "729057");
        organization.addContact(ContactType.Type.PHONE, "560409");
        organization.addContact(ContactType.Type.PHONE, "723079");
        orgs.add(organization);

        address = new AddressStub("�������������", 89, ' ', 1, 0);
        place = new PlaceStub(39.838989, 59.203725, address);
        organization = new OrganizationStub("��� �������� �������������� ������ (�� ��)", "������ ���� �������� ������������ �������������� ������ ��������� �� ����� �� �������� ���������� ���� ������ - ����� ������������� ��� ����� 89. ������ ����� ��� ����� , �� ������� ����������� ��������� �������� ������� � ���� �������������� .� ������ ���������� ��� ��������� ��� � ��������.", place);
        organization.addContact(ContactType.Type.PHONE, "534233");
        organization.addContact(ContactType.Type.PHONE, "519099");
        orgs.add(organization);

        address = new AddressStub("����������� �������", 2, ' ', 1, 0);
        place = new PlaceStub(39.884471,59.222942, address);
        organization = new OrganizationStub("������� ����-�����", "�������� ����� �����-����� ��� ������ ����������� �������� ������� �1 � �������� ������� ������������ �����, �������� �������� �������� � ��������� �������. ������� ���������� ����������� ������, ��� ������ ��������� � ������ ������� ����� �����.", place);
        organization.addContact(ContactType.Type.EMAIL, "info@elkipalki.ru");
        organization.addContact(ContactType.Type.PHONE, "724774");
        orgs.add(organization);

        address = new AddressStub("�����������", 25, ' ', 1, 0);
        place = new PlaceStub(39.872371, 59.219709, address);
        organization = new OrganizationStub("������ ��� \"�����\"", "��������� ��� ������������ 30 ���� � ������������ ���������� � ����� ��������� ������. ����� ������ ������� ����� ������� ���������� ������������ ����. ������� ����� ������������ � �������� � ���������� ��������.", place);
        organization.addContact(ContactType.Type.EMAIL, "hotel@spasskaya.ru");
        organization.addContact(ContactType.Type.PHONE, "787565 (���.2170");
        orgs.add(organization);
        categoryDrink.addByOrganization(organization);

        address = new AddressStub("�������������", 85, ' ', 1, 0);
        place = new PlaceStub(39.843894, 59.207729, address);
        organization = new OrganizationStub("�������� ��������", "���������� �������� ��������� � ������������ ���� ������� ����������� �����. ����������� ��������� ������ ���� � �� ������������ ��������� �� ��������, �� ���� �� ������������ � ��������� ����� ������ �������� ������ ������������� � ������������ ���������� ��������� ������.", place);
        organization.addContact(ContactType.Type.PHONE, "537845");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("���������", 11, ' ', 1, 0);
        place = new PlaceStub(39.883779, 59.2197, address);
        organization = new OrganizationStub("�������� �����", "�������-��������������� �������� ������. �������, �����������, �������� ����� ����������� � ���������� ����������, ��������, ��������, ...", place);
        organization.addContact(ContactType.Type.EMAIL, "mea35@mail.ru");
        organization.addContact(ContactType.Type.PHONE, "210321");
        organization.addContact(ContactType.Type.PHONE, "89216018180");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�������� ������", 6, ' ', 1, 0);
        place = new PlaceStub(39.888495, 59.221675, address);
        organization = new OrganizationStub("�������� �����", "���� �� ������������ ���������� ������� � ������ � ������ ��������� ����������� ������ ������������ ����������� � ������������ ������. ��������� ������������� � ����� ������������ ������ �������.", place);
        organization.addContact(ContactType.Type.PHONE, "722600");
        organization.addContact(ContactType.Type.PHONE, "721692");
        organization.addContact(ContactType.Type.PHONE, "���� - 722600");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�������� ������", 13, ' ', 1, 0);
        place = new PlaceStub(39.886519, 59.221224, address);
        organization = new OrganizationStub("�������� ���� �������", "��� �������, ����� ������ ������� ����� �������� � �������� ���������� �� ���������� � ���������� ������. ������ � ���������� ��������� ��� �������� �������� ��� �������� �������� � ������������� �����������, ��������� � �����������, ����������� � ������� ��������.", place);
        organization.addContact(ContactType.Type.EMAIL, "info@semvecherov.ru");
        organization.addContact(ContactType.Type.PHONE, "728282");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("������������� ����������", 44, '�', 1, 0);
        place = new PlaceStub(39.906992, 59.2197, address);
        organization = new OrganizationStub("���������-���������� �������� ������", "������������� ��������� ����������� \"���������-���������� �������� \"������\".", place);
        organization.addContact(ContactType.Type.EMAIL, "spektr@vologda.ru");
        organization.addContact(ContactType.Type.PHONE, "762075");
        orgs.add(organization);
        categorySport.addByOrganization(organization);

        address = new AddressStub("����������", 23, ' ', 1, 0);
        place = new PlaceStub(39.895188, 59.219364, address);
        organization = new OrganizationStub("�������� ��������л", "40 ���������� ����, ����������� �����, ������ �������.", place);
        organization.addContact(ContactType.Type.EMAIL, "");
        organization.addContact(ContactType.Type.PHONE, "721782");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("����������", 19, ' ', 1, 0);
        place = new PlaceStub(39.893912, 59.220188, address);
        organization = new OrganizationStub("������", "�������� �������� �����.", place);
        organization.addContact(ContactType.Type.EMAIL, "info@kyoto-vologda.ru");
        organization.addContact(ContactType.Type.PHONE, "720627");
        orgs.add(organization);
        categoryFood.addByOrganization(organization);

        address = new AddressStub("�. ���������", 13, ' ', 1, 0);
        place = new PlaceStub(39.887283, 59.217977, address);
        organization = new OrganizationStub("������ ���� ����������", "����� �������������� ����������� ��� � ����������� ������� � ������ � ���� ������������� ������� ������� �������", place);
        organization.addContact(ContactType.Type.PHONE, "707555");
        organization.addContact(ContactType.Type.PHONE, "702888");
        orgs.add(organization);
        categorySport.addByOrganization(organization);
    }

    private static class OrganizationStub {
        String name;
        String desc;
        PlaceStub place;
        Set<ContactStub> contacts = new HashSet<ContactStub>(2);

        public OrganizationStub(String name, String desc, PlaceStub place) {
            this.name = name;
            this.desc = desc;
            this.place = place;
        }

        public void addContact(ContactType.Type type, String info) {
            contacts.add(new ContactStub(type, info));
        }
    }

    private static class ContactStub {
        ContactType.Type type;
        String info;

        public ContactStub(ContactType.Type type, String info) {
            this.type = type;
            this.info = info;
        }


    }

    private static class PlaceStub {
        double lat, alt;
        AddressStub address;

        public PlaceStub(double lat, double alt, AddressStub address) {
            this.lat = lat;
            this.alt = alt;
            this.address = address;
        }
    }

    private static class AddressStub {

        String street;
        int house;
        char letter;
        int floor;
        int flat;

        public AddressStub(String street, int house, char letter, int floor, int flat) {
            this.street = street;
            this.house = house;
            this.letter = letter;
            this.floor = floor;
            this.flat = flat;
        }
    }

    private static class CategoryStub {
        Set<PositionStub> positions = new HashSet<PositionStub>();

        String name;
        int order;

        public CategoryStub(String name, int order) {
            this.name = name;
            this.order = order;
        }

        public void addPosition(PositionStub position) {
            positions.add(position);
        }

        public void addByOrganization(OrganizationStub organization) {
            positions.add(new PositionStub(organization.name, organization));
        }
    }

    private static class PositionStub {
        String name;
        OrganizationStub organization;

        public PositionStub(String name, OrganizationStub organization) {
            this.name = name;
            this.organization = organization;
        }
    }



}

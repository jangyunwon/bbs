[결과]
2^3=8
I I  O
--a_exponent가 음수이면 값을 0으로 변경하고, 1을 반환
create or replace compute_power(
a_num In number,
a_exponent IN OUT number,
a_power OUT number
);
IS
BEGIN
	IF a_exponent < 0 THEN
	a_exponent :=0;
	END IF;
	a_power :=1;
	
	for IN 1..a_exponent loop
	a_power := a_power*a_num
	
	end loop;
END;
a : array := (2.0, 36.0, 3.0, 4.0, 1.0, 9.0); 
notDone := 1.0;
size := a.length;

while notDone loop 
    notDone := 0.0;
    index := 0.0;
    nextVal := 1.0;
        while index < size loop 

        if nextVal = size then
            nextVal := index;
        end if;

        currentValue := a(index);
        nextValue := a(nextVal);

        if currentValue > nextValue then 
            notDone := 1.0;
            temp := a(index);
            temp2 := a(nextVal);
            a(index) := temp2;
            a(nextVal) := temp;

        end if;
        index := index + 1.0;
        nextVal := index + 1.0;
    end loop;
end loop;

Put_Line(a);

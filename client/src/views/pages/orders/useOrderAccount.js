import { useEffect, useState } from 'react';

const useOrderAccount = () => {

    const [nhanvien, setNhanvien] = useState();

    useEffect(() => {
        if (localStorage.user) {
            const user = JSON.parse(localStorage.user) || null;
            setNhanvien(user);
        }
    }, []);

    return nhanvien;
};

export default useOrderAccount;
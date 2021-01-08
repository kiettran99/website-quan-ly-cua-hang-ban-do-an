import { useEffect, useState } from 'react';
import { getOrders } from '../../../api/ordersApi';

const useGetOrders = () => {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        getOrders().then((res) => setOrders(res));
    }, []);

    return orders;
}

export default useGetOrders;
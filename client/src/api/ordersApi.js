import axios from "../common/axiosClient";

export const checkoutOrder = async (data) => {
    const url = `/orders/checkout`;
    const response = await axios.post(url, data);
    return response.data;
};

export const getOrders = async () => {
    const url = `/orders/`;
    const response = await axios.get(url);
    return response.data;
};

export const getOrderById = async (id) => {
    const url = `/orders/${id}`;
    const response = await axios.get(url);
    return response.data;
};
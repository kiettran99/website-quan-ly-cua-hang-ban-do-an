import axios from "../common/axiosClient";

export const login = async (username, password) => {
  const url = `/users/signin`;

  const response = await axios.post(url, { username, password });
  return response.data;
};

export const register = async (formData) => {
  const url = `/users/signup`;

  const response = await axios.post(url, formData);
  return response.data;
};
import React, { useState, useEffect, lazy } from "react";
import {
  CButton,
  CBadge,
  CCard,
  CCardBody,
  CCardHeader,
  CDataTable,
  CLink,
  CRow,
  CContainer,
} from "@coreui/react";
import CIcon from "@coreui/icons-react";
import Icon from "@mdi/react";
import { mdiFoodForkDrink } from "@mdi/js";
import CreateFood from "./createFood";
import EditFood from "./EditFood";
import { getMonAns, removeMonAn } from '../api/MonAnApi'

const fields = [
  { key: "ma_id", label: "STT", _style: { width: "10%" } },
  { key: "ma_ten", label: "Tên", _style: { width: "15%" } },
  { key: "ma_giaban", label: "Giá bán", _style: { width: "10%" } },
  { key: "ma_giavon", label: "Giá vốn", _style: { width: "10%" } },
  { key: "ma_donvitinh", label: "Đơn vị", _style: { width: "20%" } },
  // { key: "ma_hinhanh", label: "Hình ảnh", _style: { width: "20%" } },
  { key: "ma_motachitiet", label: "Mô tả", _style: { width: "20%" } },

  { key: "action", label: "ACTION", _style: { width: "10%" } },
];
const getBadge = (status) => {
  switch (status) {
    case "Active":
      return "success";
    case "Inactive":
      return "secondary";
    case "Pending":
      return "warning";
    case "Banned":
      return "danger";
    default:
      return "primary";
  }
};
function MonAn() {
  const [MonAns, setMonAns] = useState(null);
  const [loading, setLoading] = useState(true);
  const [collapse, setCollapse] = useState(false);
  const [success, setSuccess] = useState(false);
  const [modal, setModal] = useState(false);

  const [editModal, setEditModal] = useState(false);
  const [selectMonAn, setSelectMonAn] = useState(0);

  const createSuccess = () => {
    setSuccess(!success);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getMonAns();
        setMonAns(response);
        setLoading(false);
      } catch (err) {
        setMonAns(null);
        setLoading(true);
        console.log(err);
      }
    };
    fetchData();
  }, [success]);

  const toggleModal = () => {
    setModal(!modal);
  };

  const toggleEditModal = () => {
    setEditModal(!editModal);
  };
  // const monanlist = [
  //   {
  //     id: "1",
  //     ma_ten: "nước uống",
  //     ma_giaban: "100000",
  //     ma_giavon: "50000",
  //     ma_donvitinh: "ly",
  //     ma_hinhanh: " ",
  //     ma_motachitiet: "fjdgfgfdhg",
  //   },
  //   {
  //     id: "2",
  //     ma_ten: "nước uống",
  //     ma_giaban: "100000",
  //     ma_giavon: "50000",
  //     ma_donvitinh: "ly",
  //     ma_hinhanh: " ",
  //     ma_motachitiet: "fjdgfgfdhg",
  //   },
  //   {
  //     id: "3",
  //     ma_ten: "7up ",
  //     ma_giaban: "100000",
  //     ma_giavon: "50000",
  //     ma_donvitinh: "ly",
  //     ma_hinhanh: " ",
  //     ma_motachitiet: "fjdgfgfdhg",
  //   },
  // ];
  return (
    <>
      <CCard>
        <CCardHeader className="CCardHeader-title">
          <CContainer>
            <CRow className="d-flex justify-content-between">
              <h1>Danh sách món ăn</h1>
              <div className="card-header-actions">
                <CButton
                  onClick={toggleModal}
                  block
                  variant="outline"
                  color="primary"
                  size="sm"
                  className="CCardHeader-title-btn-createfood"
                >
                  <Icon
                    path={mdiFoodForkDrink}
                    size={1}
                    title="Create Food"
                    className="mr-1"
                  />
                  Thêm món ăn
                </CButton>
              </div>
            </CRow>
          </CContainer>
        </CCardHeader>

        <CCardBody>
          <CDataTable
            items={MonAns}
            fields={fields}
            striped
            itemsPerPage={5}
            pagination
            scopedSlots={{
              index: (item) => <td>{item.ma_id}</td>,
              name: (item) => (
                <td>
                  <CBadge color={getBadge(item.ma_ten)}>{item.ma_ten}</CBadge>
                </td>
              ),
              // ban: (item) => (
              //   <td>
              //     <CBadge color={getBadge(item.ma_giaban)}>
              //       {item.ma_giaban}
              //     </CBadge>
              //   </td>
              // ),
              // von: (item) => (
              //   <td>
              //     <CBadge color={getBadge(item.ma_giavon)}>
              //       {item.ma_giavon}
              //     </CBadge>
              //   </td>
              // ),
              // donvitinh: (item) => (
              //   <td>
              //     <CBadge color={getBadge(item.ma_donvitinh)}>
              //       {item.ma_donvitinh}
              //     </CBadge>
              //   </td>
              // ),
              // hinhanh: (item) => (
              //   <td>
              //     <CBadge color={getBadge(item.ma_hinhanh)}>
              //       {item.ma_hinhanh}
              //     </CBadge>
              //   </td>
              // ),
              // mota: (item) => (
              //   <td>
              //     <CBadge color={getBadge(item.ma_motachitiet)}>
              //       {item.ma_motachitiet}
              //     </CBadge>
              //   </td>
              // ),
              action: (item) => (
                <td style={{ display: "flex", justifyContent: "start" }}>
                  <div
                    style={{
                      display: "flex",
                      width: "80%",
                      justifyContent: "space-between",
                    }}
                  >
                    <CLink className="c-subheader-nav-link" onClick={() => {
                      setSelectMonAn(item);
                      console.log(item);
                      toggleEditModal();            
                    }}>
                      <CIcon name="cil-pencil" alt="Edit" />
                      {/* &nbsp;Edit */}
                    </CLink>
                    <CLink className="c-subheader-nav-link" onClick={() => {
                        const result = window.confirm("Xác nhận xóa sản phẩm !");

                        if (result) {
                          removeMonAn(item.ma_id);
                        }
                    }}>
                      <CIcon
                        style={{ color: "red" }}
                        name="cil-trash"
                        alt="Delete"
                      />
                      {/* &nbsp;Edit */}
                    </CLink>
                  </div>
                </td>
              ),
            }}
          />
        </CCardBody>
        <CreateFood
          modal={modal}
          toggleModal={toggleModal}
          createSuccess={createSuccess}
        />
        <EditFood
          editModal={editModal}
          toggleEditModal={toggleEditModal}
          createSuccess={createSuccess}
          selectMonAn={selectMonAn}
        />
      </CCard>
    </>
  );
}

export default MonAn;
